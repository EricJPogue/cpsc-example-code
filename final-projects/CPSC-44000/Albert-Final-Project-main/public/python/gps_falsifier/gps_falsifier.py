#
# gps_falsifier : Malicious Modification Script
# Author: George Pappas
# Original Creation Date: July 2013
# Version 1.0
#

# Import Declarations.
import os               # Standard Library OS functions
import piexif
import random
import shutil

# Generates random values for date.
def genRandomDate(randomDictionary):
    randYear = random.randint(1990, 2020) # Generates random year.
    randMonth = random.randint(1,12)  # Generates random month.

    if randMonth == 2:    # For the month of february.
        randDay = random.randint(1, 28)
    else:
        randDay = random.randint(1,30)
    
    # Renerates random time.
    randHour = random.randint(1,23)
    randMinute = random.randint(1,59)
    randSecond = random.randint(1,59)

    randDate = ("%d:%02d:%02d %02d:%02d:%02d" % (randYear, randMonth, randDay, randHour, randMinute, randSecond))

    randomDictionary[0] = randDate  # Adds new date and time to randomDictionary.

    return randomDictionary
# End genRandomDate =====================================

# Generates random values for GPS.
def genRandomGPS(randomDictionary):
    # Generates random numbers for latitude.
    randLatDeg = random.randint(0, 89)
    randLatMin = random.randint(0, 59)
    randLatSec = random.randint(0, 59)
    randLatRef = random.randint(0,1)

    # Generates random numbers for longitude.
    randLonDeg = random.randint(0, 179)
    randLonMin = random.randint(0, 59)
    randLonSec = random.randint(0, 59)
    randLonRef = random.randint(0,1)

    # Formats randLat & randLon as a tuple.
    randLat = ((randLatDeg, 1), (randLatMin, 1), (randLatSec, 1))
    randLon = ((randLonDeg, 1), (randLonMin, 1), (randLonSec, 1))

    # Sets north, south, east, or west for latitude & longitude reference.
    if randLatRef == 0:
        randLatRef = 'N'
    else:
        randLatRef = 'S'

    if randLonRef == 0:
        randLonRef = 'W'
    else:
        randLonRef = 'E'

    # Adds random gps values to randomDictionary.
    randomDictionary[1] = randLat
    randomDictionary[2] = randLatRef
    randomDictionary[3] = randLon
    randomDictionary[4] = randLonRef

    return randomDictionary
# End genRandomGPS =====================================

# Main Function.
if __name__ == '__main__':
    # Introduction statement.
    print("===== Program Start =====")

    # Dictionary Declaration.
    randomDictionary = {}   # Creates random dictionary.

    imageName = 'IMG_7867 copy.jpeg'    # File name.
    falseImageName = 'FALSIFIED_' + imageName    # File name for image with falsified data.

    print()
    print('Using image: {}'.format(imageName))

    genRandomDate(randomDictionary) # Generates random date & time.
    genRandomGPS(randomDictionary)  # Generates random gps values.

    shutil.copy(imageName, falseImageName)   # Creates copy of image file.
    fakeImageExifData = piexif.load(falseImageName)   # Loads image EXIF data into imageData.
    fakeImageGpsData = fakeImageExifData['GPS'] # Loads image GPS data into fakeImageGpsData.

    # Displays gps data of file.
    print()
    print('Real GPS data:')
    print('{}'.format(fakeImageGpsData))

    fakeImageExifData['Exif'][piexif.ExifIFD.DateTimeOriginal] = randomDictionary[0]    # Writes randomized time to fakeImageGpsData.
    fakeImageExifData['Exif'][piexif.ExifIFD.DateTimeDigitized] = randomDictionary[0]   # Writes randomized time to fakeImageGpsData.

    fakeImageGpsData[piexif.GPSIFD.GPSDateStamp] = randomDictionary[0]  # Writes randomized date to fakeImageGpsData.
    fakeImageGpsData[piexif.GPSIFD.GPSLatitude] = randomDictionary[1]   # Writes randomized latitude to fakeImageGpsData.
    fakeImageGpsData[piexif.GPSIFD.GPSLatitudeRef] = randomDictionary[2]    # Writes randomized latitude reference to fakeImageGpsData.
    fakeImageGpsData[piexif.GPSIFD.GPSLongitude] = randomDictionary[3]  # Writes randomized longitude to fakeImageGpsData.
    fakeImageGpsData[piexif.GPSIFD.GPSLongitudeRef] = randomDictionary[4]   # Writes randomized longitude reference to fakeImageGpsData.

    # Displays gps data of falsified file.
    print()
    print('Falsified GPS data:')
    print('{}'.format(fakeImageGpsData))

    exif_bytes = piexif.dump(fakeImageExifData) # Converts exif data dictanary into bytes.
    piexif.insert(exif_bytes, falseImageName)   # Writes falsified data to new file.

    # Save location statement.
    print()
    print("File saved in script directory.")

    # TODO: delete if needed.
    #try:
    #    if os.path.dirname(imageName) is not '':
    #        shutil.move(falseImageName, os.path.dirname(imageName))    # Moves file to original image directory.
    #    else:
    #        print()
    #        print("File saved in script directory because user did not specify original image directory.")
    #except:
    #    os.remove(falseImageName)   # Deletes new file if it cannot be moved to new directory.
    #    print()
    #    print("File already exists in specified directory. Please delete and try again.")

    # Finishing statement.
    print()
    print("===== Program End =====")
    print()
# End Main Function =====================================
