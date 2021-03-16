# Import Declarations for Azure Functions.
import azure.functions as func
import requests
from io import BytesIO
import json
import logging

# Import Declarations for gps_extractor.
from PIL import Image   # import the Python Image Library
from PIL.ExifTags import TAGS, GPSTAGS  # along with TAGS and GPS related TAGS

# Extract EXIF Data.
def ExtractGPSDictionary(fileName):
    try:
        # TODO: Check if see if BytesIO needs to be closed.
        pilImage = Image.open(BytesIO(fileName.content))    # Opens image & utilizes a binary stream using an in-memory bytes buffer which inherits BufferedIOBase called 'BytesIO'.
        exifData = pilImage._getexif()  # Extracts EXIF data.
    except IOError:
        func.alert("Failed to open image file {}".format(fileName)) # TODO: Change alert as it will crash the code.
        return None, None

    # Iterate through the exifData
    # Searching for GPS Tags
    # Set default values for some image attributes.
    imageTimeStamp = "NA"
    CameraModel = "NA"
    CameraMake = "NA"

    # Only bother if the image has exif data.
    if exifData:
        # Iterate through the values in the exif dictionary.
        for tag, theValue in exifData.items():
            tagValue = TAGS.get(tag, tag)   # Obtain the tag.

            # Collect basic image data if available.
            if tagValue == 'DateTimeOriginal':
                imageTimeStamp = exifData.get(tag)

            if tagValue == 'Make':
                cameraMake = exifData.get(tag)

            if tagValue == 'Model':
                cameraModel = exifData.get(tag)
            
            # Check the tag for GPS.
            if tagValue == "GPSInfo":
                # Creates a Dictionary to hold GPS Data.
                gpsDictionary = {}

                # Loops through the GPS Information.
                for curTag in theValue:
                    gpsTag = GPSTAGS.get(curTag, curTag)
                    gpsDictionary[gpsTag] = theValue[curTag]    # Add the text name and value to our dictionary.

                # basicExifData = [imageTimeStamp, cameraMake, cameraModel] # Commented out because we're not using cameraMake or cameraModel.
                basicExifData = imageTimeStamp  # Saves image date and time.
                return gpsDictionary, basicExifData
    else:
        return None, None
# End ExtractGPSDictionary ===========================

# Extract the Latitude and Longitude Values.
def ExtractLatLon(gps):
    if (("GPSLatitude" in gps) and ("GPSLongitude" in gps) and ("GPSLatitudeRef" in gps) and ("GPSLongitudeRef" in gps)):
        latitude = gps["GPSLatitude"]
        latitudeRef = gps["GPSLatitudeRef"]
        longitude = gps["GPSLongitude"]
        longitudeRef = gps["GPSLongitudeRef"]

        lat = ConvertToDegrees(latitude)
        lon = ConvertToDegrees(longitude)

        # Check Latitude Reference
        # If South of the Equator then lat value is negative
        if latitudeRef == "S":
            lat = 0 - lat

        # Check Longitude Reference
        # If West of the Prime Meridian in
        # Greenwich then the Longitude value is negative
        if latitudeRef == "W":
            lat = 0 - lon

        # Checks for altitude.
        if (("GPSAltitude" in gps) and ("GPSAltitudeRef" in gps)):
            altitude = gps['GPSAltitude']
            altitudeRef = gps['GPSAltitudeRef']
            
            gpsCoor = {"Lat": lat, "LatRef":latitudeRef, "Lon": lon, "LonRef": longitudeRef, "Alt": altitude, "AltRef": altitudeRef}
        else:
            gpsCoor = {"Lat": lat, "LatRef":latitudeRef, "Lon": lon, "LonRef": longitudeRef, "Alt": '', "AltRef": ''}

        return gpsCoor
    else:
        return None
# End Extract Lat Lon ===========================

# Convert GPSCoordinates to Degrees.
def ConvertToDegrees(gpsCoordinate):
    deg, mins, secs = gpsCoordinate

    try:
        degrees = float(deg)
    except:
        degrees = 0.0

    try:
        minutes = float(mins)
    except:
        minutes = 0.0

    try:
        seconds = float(secs)
    except:
        seconds = 0.0

    floatCoordinate = float(degrees + (minutes / 60.0) + (seconds / 3600.0))

    return floatCoordinate
# End ConvertToDegrees ===========================

# Runs through script.
def getGPSCoordinates(targetFile, imageName, coordinates):    
    # Offsets into the return EXIFData for TimeStamp, Camera Make and Model
    TS = 0
    MAKE = 1
    MODEL = 2

    try:
        gpsDictionary, exifList = ExtractGPSDictionary(targetFile)
    except TypeError:
        gpsDictionary = None
        exifList = None

    if (exifList):
        coordinates.update(dateTime = str(exifList))  # Updates coordinate dictionary.
    else:
        coordinates.update(dateTime = 'No Date/Time Data') # Updates coordinate dictionary.

    if (gpsDictionary):
        # Obtains the Lat Lon values from the gpsDictionary.
        # Converted to degrees.
        # The return value is a dictionary key value pairs.
        dCoor = ExtractLatLon(gpsDictionary)

        lat = dCoor.get("Lat")
        latRef = dCoor.get("LatRef")

        lon = dCoor.get("Lon")
        lonRef = dCoor.get("LonRef")

        alt = dCoor.get("Alt")
        altRef = dCoor.get("AltRef")

        if (lat and lon and latRef and lonRef):
            if (alt and altRef):
                coordinates.update(latRef = str(latRef), lat = str(lat), lonRef = str(lonRef), lon = str(lon), alt = str(alt))  # Updates coordinate dictionary.

                # Logs image data.
                logging.info(imageName+':')
                logging.info('     '+'Latitude:   '+str(latRef)+'  '+str(lat))
                logging.info('     '+'Longitude:  '+str(lonRef)+'  '+str(lon))
                logging.info('     '+'Altitude:      '+str(alt))
            else:
                coordinates.update(latRef = str(latRef), lat = str(lat), lonRef = str(lonRef), lon = str(lon), alt = 'No ALT Data') # Updates coordinate dictionary.
                
                # Logs image data.
                logging.info(imageName+':')
                logging.info('     '+'Latitude:   '+str(latRef)+'  '+str(lat))
                logging.info('     '+'Longitude:  '+str(lonRef)+'  '+str(lon))
                logging.info('     '+'Altitude:      '+'No ALT Data')
        else:
            coordinates.update(latRef = ' ', lat = 'No LAT Data', lonRef = ' ', lon = 'No LON Data', alt = 'No ALT Data')   # Updates coordinate dictionary.

            # Logs image data.
            logging.info(imageName+':')
            logging.info('     '+'Latitude:  '+'No LAT Data')
            logging.info('     '+'Longitude: '+'No LON Data')
            logging.info('     '+'Altitude:  '+'No ALT Data')
    else:
        coordinates.update(latRef = ' ', lat = 'No LAT Data', lonRef = ' ', lon = 'No LON Data', alt = 'No ALT Data')   # Updates coordinate dictionary.
        
        # Logs image data.
        logging.info(imageName+':')
        logging.info('     '+'Latitude:  '+'No LAT Data')
        logging.info('     '+'Longitude: '+'No LON Data')
        logging.info('     '+'Altitude:  '+'No ALT Data')

    return coordinates
# End getGPSCoordinates ===========================

# Main function.
def main(req: func.HttpRequest) -> func.HttpResponse:
    logging.info('Python HTTP trigger function processed a request.')

    # Gets image path from URL.
    onlinePath = req.params.get('path')
    if not onlinePath:
        try:
            req_body = req.get_json()
        except ValueError:
            pass
    else:
        onlinePath = req.params.get('path')

    # Gets image name from URL.
    imageName = req.params.get('imagename')
    if not imageName:
        try:
            req_body = req.get_json()
        except ValueError:
            pass
    else:
        imageName = req.params.get('imagename')

    # URL Example: https://albert-final-project-function.azurewebsites.net/api/gps_extractor?path=albertprojectstorage.blob.core.windows.net/user-image&imagename=Biking.jpg
    url = "https://" + str(onlinePath) + "/" + str(imageName)   # Creates image path URL.
    try:
        response = requests.get(url)    # Gets content from image path URL.
    except:
        func.alert('Image file cannot be found')    # TODO: Change alert as it will crash the code.

    logging.info(' ')
    logging.info("===== Script Start =====")
    finalCoordinates = {}   # Creates dictionary.
    finalCoordinates = getGPSCoordinates(response, imageName, finalCoordinates)  # Computes file.
    logging.info("===== Script End =====")
    logging.info(' ')

    finalCoordinatesJSON = json.dumps(finalCoordinates) # Creates JSON file from dictionary.

    if onlinePath:
        return func.HttpResponse(finalCoordinatesJSON)
    else:
        return func.HttpResponse(
            "File was not found",
            status_code=400
        )
# End Main function ===========================
