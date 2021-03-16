// Call this from the developer console and you can control both instances
var calendars = {};
const PROXY_URL = "https://cors-anywhere.herokuapp.com/";
const API_KEY = "token=-wT5U3k_8APimS4Imb-23ieRQX2xXbo1MmmJF0zMwX3Ajnbsezk";



$(document).ready( function() {
    console.info(
        'Welcome to the CLNDR demo. Click around on the calendars and' +
        'the console will log different events that fire.');

    var eventArray = [];
    var indexRequest = new XMLHttpRequest();
    indexRequest.open('GET', PROXY_URL+'https://api.pandascore.co/ow/matches?page[size]=100&page[number]=1&&' + API_KEY);
    indexRequest.onload = function() {
        matches = JSON.parse(indexRequest.responseText);
        for(i = 0; i < matches.length; i++){
            eventArray[i]={
                title: matches[i].name,
                date: (matches[i].original_scheduled_at).substring(0,10)
            }
        }
        calendars.clndr1 = $('.cal1').clndr({
            events: eventArray,
            clickEvents: {
                click: function (target) {

                    for(i=0;i<(target.events).length; i++)
                    {
     
                        document.getElementById("modalText").insertAdjacentHTML("beforeend",target.events[i].title + "<br>")
                        console.log(target)
                    }
                     $("#exampleModal").modal();
                },
            },
            multiDayEvents: {
                singleDay: 'date',
                endDate: 'endDate',
                startDate: 'startDate'
            },
            showAdjacentMonths: true,
            adjacentDaysChangeMonth: false
        });

        $("#exampleModal").on("hidden.bs.modal", function () {
            document.getElementById("modalText").innerHTML = "";
        });
    
        // Bind all clndrs to the left and right arrow keys
        $(document).keydown( function(e) {
            // Left arrow
            if (e.keyCode == 37) {
                calendars.clndr1.back();
            }
    
            // Right arrow
            if (e.keyCode == 39) {
                calendars.clndr1.forward();
            }
        });
    }
    indexRequest.send();




});





function loadMatches(){
    var newEvent={};
    var indexRequest = new XMLHttpRequest();
    indexRequest.open('GET', PROXY_URL+'https://api.pandascore.co/ow/matches?range[begin_at]=2020-12-01T17:00:00Z,2020-12-30T22:00:00Z&&' + API_KEY);
    indexRequest.onload = function() {
        matches = JSON.parse(indexRequest.responseText);
        for(i = 0; i < matches.length; i++){
            newEvent.title = matches[i].name;
            newEvent.ate = (matches[i].original_scheduled_at).substring(0,10);
            eventArray.push(newEvent)
        }
    }
    indexRequest.send();
}