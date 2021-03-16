//
//Authors:  Nathan, Michael, Josh
//Class:   Software Engineering & Web & Distributed Programming 
//Odyssey branch previous-matches
//Description:
//This file contains all of the needed functions to populate the previous match patch
//It will allow you to select from the Leagues>Series>Tournaments>Matches given from the api
//When you select A League, the series from that league will populate the respective select box
//similarly when you you select a series and tournament, Finally when the tournament is selected
//a table will generate with all the matches from that tournament.

const API_KEY = "token=-wT5U3k_8APimS4Imb-23ieRQX2xXbo1MmmJF0zMwX3Ajnbsezk";
const PROXY_URL = "https://cors-anywhere.herokuapp.com/";
var leagues;
var series;
var tournaments;

function loadLeagues(){
    var indexRequest = new XMLHttpRequest();
    indexRequest.open('GET', PROXY_URL+'https://api.pandascore.co/ow/leagues?' + API_KEY);
    indexRequest.onload = function() {
        leagues = JSON.parse(indexRequest.responseText);
        for(i = 0; i < leagues.length; i++){
            var cleanedString = cleanString(leagues[i].slug)
            addOption(document.getElementById('leaguesSelect'), cleanedString, leagues[i].id)
        }
        loadSeries();
    }
    indexRequest.send();

}

function loadSeries(){
    var selcetedLeagueID = document.getElementById('leaguesSelect').value;
    var selectedLeagueSeries = [];
    document.getElementById('seriesSelect').length = 0;
    document.getElementById('tournamentSelect').length = 0;
    for(i = 0; i < leagues.length; i++){
        if (selcetedLeagueID == leagues[i].id){
            selectedLeagueSeries = leagues[i].series;
        }
    }
    for(i = 0; i < selectedLeagueSeries.length; i++){
        var cleanedString = cleanString(selectedLeagueSeries[i].slug)
        addOption(document.getElementById('seriesSelect'), cleanedString, selectedLeagueSeries[i].id)
    }
    loadTournaments();
}

function loadTournaments(){
    var selectedSeriesID = document.getElementById("seriesSelect").value;
    var selectedSeriesTournaments = [];
    var indexRequest = new XMLHttpRequest();
    document.getElementById('tournamentSelect').length = 0;
    indexRequest.open('GET', PROXY_URL+'https://api.pandascore.co/ow/series?' + API_KEY);
    indexRequest.onload = function() {
        series = JSON.parse(indexRequest.responseText);
        for(i = 0; i < series.length; i++){
            if (selectedSeriesID == series[i].id){
                selectedSeriesTournaments = series[i].tournaments;
            }
        }
        for(i = 0; i < selectedSeriesTournaments.length; i++){
            var cleanedString = cleanString(selectedSeriesTournaments[i].slug)
            addOption(document.getElementById('tournamentSelect'), cleanedString, selectedSeriesTournaments[i].id)
        }
        loadMatches();
    }
    indexRequest.send();
   
}

function loadMatches(){
    document.getElementById("matcheStatus").innerHTML = "MATCHES LOADING"
    var selectedTournamentID = document.getElementById("tournamentSelect").value;
    var selectedTournamentMatches = [];
    var indexRequest = new XMLHttpRequest();
    document.getElementById('matchesInfo').value = "";
    indexRequest.open('GET', PROXY_URL+'https://api.pandascore.co/ow/tournaments?' + API_KEY);
    indexRequest.onload = function() {
        tournaments = JSON.parse(indexRequest.responseText);
        for(i = 0; i < tournaments.length; i++){
            if (selectedTournamentID == tournaments[i].id){
                selectedTournamentMatches = tournaments[i].matches;
            }
        }
        matchTable(selectedTournamentMatches)
        if (selectedTournamentMatches.length > 0){

            document.getElementById("matcheStatus").innerHTML = "";
        }else{
            document.getElementById("matcheStatus").innerHTML = "NO MATCHES FOUND"
        }

    }
    indexRequest.send();
}

//This function will make the match table, from the provided match array
//it allows for dynamic tables to be made based on the provided array
function matchTable(matchArray){
    var col = ['Name','Start Time', 'Winner'];
    var table = document.createElement("table");
    var tr = table.insertRow(0);

    for (var i = 0; i < col.length; i++) {
        var th = document.createElement("th");
        th.innerHTML = col[i];
        tr.appendChild(th);
    }

    for (var i = 0; i < matchArray.length; i++) {
        tr = table.insertRow(-1);
        var insertString ="";
        for (var j = 0; j < col.length; j++) {
            var tabCell = tr.insertCell(-1);
            switch(j){
                case 0:
                    insertString = cleanString(matchArray[i].name)
                    tabCell.innerHTML = insertString
                    break;
                case 1: 
                    insertString = cleanString(matchArray[i].begin_at)
                    tabCell.innerHTML = insertString
                    break;
                case 2: 
                    insertString = cleanString(matchArray[i].winner_id)
                    tabCell.innerHTML = insertString
                    break;
            }
            
        }

    }
        var divShowData = document.getElementById('matchesInfo');
        divShowData.innerHTML = "";
        divShowData.appendChild(table);
}

//As json stringify usually has  - and "" this function will remove those and make a nice clean string
function cleanString(uglyString){
    var jsonAsString = JSON.stringify(uglyString);
    return jsonAsString = jsonAsString.replace(/-|"/g," ")
}

//this function will populate the selected drop down with options and allows dynamic 
function addOption(selectBox, text, value) {
    var option = document.createElement("option");
       option.text = text;
       option.value = value;
       selectBox.options.add(option);
   };
   
