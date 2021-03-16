
async function printEXIF() {
    file = await getFileName()
    const data = 'https://albert-final-project-function.azurewebsites.net/api/gps_extractor?path=albertprojectstorage.blob.core.windows.net/user-image&imagename=' + file
    obj = await getData(data);
    
    // Displays information.
    document.getElementById("date").value = obj.dateTime;
    document.getElementById("latitude").value = obj.lat + "  " + obj.latRef;
    document.getElementById("longitude").value = obj.lon + "  " + obj.lonRef;
    document.getElementById("altitude").value = obj.alt;

    return obj;
}

async function getData(data) {
    const response = await fetch(data)
    const results = await response.json()

    return results
}

async function getFileName() {
    var fullPath = document.getElementById('filename').value;
    if (fullPath) {
        var startIndex = (fullPath.indexOf('\\') >= 0 ? fullPath.lastIndexOf('\\') : fullPath.lastIndexOf('/'));
        var filename = fullPath.substring(startIndex);
    if (filename.indexOf('\\') === 0 || filename.indexOf('/') === 0) {
        filename = filename.substring(1);
        }
    }

    return filename
}

async function showMarker(myObj) {
    // Gets coordinates from object.
    latStr = myObj.lat
    lonStr = myObj.lon
    latRef = myObj.latRef
    lonRef = myObj.lonRef

    // Converts from string to float.
    var lat = parseFloat(latStr)
    var lon = parseFloat(lonStr)

    // Corrects coordinate sign for latitude.
    if (latRef == "N") {
        if (lat < 0) {
            lat = lat * -1
        }
    } else {
        if (lat > 0) {
            lat = lat * -1
        }
    }

    // Corrects coordinate sign for longitude.
    if (lonRef == "E") {
        if (lon < 0) {
            lon = lon * -1
        }
    } else {
        if (lon > 0) {
            lon = lon * -1
        }
    }

    // Adds coordinates to map and places pin if data exists.
    if (latStr == 'No LAT Data') {
        var myLatLon = await new google.maps.LatLng(41.605540, -88.077220)

        var mapOptions = {
            zoom: 8,
            center: myLatLon
        }

        var map = await new google.maps.Map(document.getElementById("map"), mapOptions)
    } else {
        var myLatLon = await new google.maps.LatLng(lat, lon)

        var mapOptions = {
            zoom: 16,
            center: myLatLon
        }   

        var map = await new google.maps.Map(document.getElementById("map"), mapOptions)

        var marker = new google.maps.Marker ({
            position: myLatLon,
            title: "Image Location"
        });

        marker.setMap(map)
    }
}

async function doall() {
    imageData = await printEXIF()   // Gets coordinates from azure function.
    showMarker(imageData)   // Displays marker on map.
}
