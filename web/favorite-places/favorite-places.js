var favoritePlaces = [
    {"content":"<strong>#1: Lombard, IL... Home Sweet Home!<strong>", "coordinates":{"lat":41.837546,"lng":-88.0146821}, "iconImagePath":"one.png"},
    {"content":"<strong>#2: Quetico!<strong>", "coordinates":{"lat":48.5,"lng":-91.3}, "iconImagePath":"two.png"},
    {"content":"Santorini, Greece", "coordinates":{"lat":36.3932,"lng":25.4615}, "iconImagePath":"three.png"},
    {"content":"Florence, Italy", "coordinates":{"lat":43.7696,"lng":11.2558}, "iconImagePath":"four.png"},
    {"content":"Myrtle Beach, SC", "coordinates":{"lat":33.6891,"lng":-78.8867}, "iconImagePath":"flag.png"},
    {"content":"Prague, Czechia", "coordinates":{"lat":50.0755,"lng":14.4378}, "iconImagePath":"flag.png"},
    {"content":"Nelson, New Zealand", "coordinates":{"lat":-41.2706,"lng":173.2840}, "iconImagePath":"flag.png"},
    {"content":"Krakow, Poland", "coordinates":{"lat":50.0647,"lng":19.9450}, "iconImagePath":"flag.png"},
    {"content":"Zakopane, Poland", "coordinates":{"lat":49.2992,"lng":19.9496}, "iconImagePath":"flag.png"},
    {"content":"Canoe Bay, WI", "coordinates":{"lat":45.3306,"lng":-91.4918}, 
        "iconImagePath":"https://maps.google.com/mapfiles/kml/shapes/info-i_maps.png"}
]; 
var currentPlaceIndex = favoritePlaces.length-1;
var currentPlace = favoritePlaces[currentPlaceIndex];

function initApplication() {
    console.log("Favorite Places - Starting!");
}

function initMap() {
    gMap = new google.maps.Map(document.getElementById("myMapID"), {
        "center": {"lat": 41.878, "lng": 10}, "zoom": 3});

    // Note that several message boards suggested using 'idle' instead of 'bounds_changed' because 
    // 'bounds_changed' gets called over and over when the user drags the map.
    google.maps.event.addListener(gMap, 'idle', function() { updateGame()});

/*
    for (i=0; i<favoritePlaces.length; i++) { 
        addMarker(currentPlace);
        nextPlace();
    }
*/
}

function updateGame() {
    console.log("updateGame()");

    var zoomLevel = gMap.getZoom();
    console.log("Zoom Level:" + zoomLevel);

    var inBounds = false;
    console.log("coords:" + JSON.stringify(currentPlace.coordinates));
    if (gMap.getBounds().contains(currentPlace.coordinates)) {
        var inBounds = true;
        console.log("Inbounds");
    }

    if ((zoomLevel > 7) && (inBounds)) {
        console.log("Found!!!");
        addMarker(currentPlace);
        nextPlace();
    }


    
}

function nextPlace() {
    currentPlaceIndex--;
    currentPlace = favoritePlaces[currentPlaceIndex];
}

function addMarker(markerContent) {
    var marker = new google.maps.Marker({position:markerContent.coordinates, map:gMap});
    if (markerContent.iconImagePath) {
        marker.setIcon(markerContent.iconImagePath);
    }

    if (markerContent.content) {
        var infoWindow = new google.maps.InfoWindow({"content":markerContent.content});
        marker.addListener("click", function() { infoWindow.open(gMap, marker) });
    }
}