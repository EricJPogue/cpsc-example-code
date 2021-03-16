var obj;
var role;
var increase = true;
const proxyurl = "https://cors-anywhere.herokuapp.com/";
var playerId = 19136;
const token = "?token=wPrHIPK-H1sa139CRk3ujlb7vZw8oPfvNHueoDcBSNnq6n4T6b0";
var teamListArrR1 = [];
var teamListArrR2 = [];
var teamListArrR3 = [];
function intro(){
    

    var indexRequest = new XMLHttpRequest();
    indexRequest.open('GET', proxyurl+'https://api.pandascore.co/ow/teams?&token=-wT5U3k_8APimS4Imb-23ieRQX2xXbo1MmmJF0zMwX3Ajnbsezk');
   
    indexRequest.onload = function() {
        var teamList = JSON.parse(indexRequest.responseText);
        console.log(teamList);
        makeTeamList(teamList);
        playGame()
    }
    indexRequest.send();
}
function makeTeamList(jsonInfo){
    for (i = 0; i < 8; i++) {
        var randomin = Math.floor(Math.random() * jsonInfo.length)
        teamListArrR1.push(jsonInfo[randomin]);
        jsonInfo.splice(randomin, 1);
      }
    console.log(teamListArrR1);

}
//Returning a number from range -3 to +3 where that is the shift in games that the first team has won by
function returnGame()
{
    var teamAwin=0;
    var teamBwin=0;
    var roundCount =0;
    while (teamAwin != 3 && teamBwin != 3)
    {
        var randomin = Math.floor(Math.random() * 100)
        if (randomin > 50)
        {
            teamAwin ++;
        }
        else{
            teamBwin ++;
        }
        console.log(teamAwin,teamBwin)

    }
    return teamAwin-teamBwin;
}
//this is all hard coded no loops, very sorry
function playGame()
{
    //start round 1
    var winner= returnGame();
    console.log(winner);
    if (winner > 0)
    {
        document.getElementById("r1g1u").innerHTML = teamListArrR1[0].name + "   3" ;
        document.getElementById("r1g1l").innerHTML = teamListArrR1[1].name + "   " + (3-winner);
        document.getElementById("r1g1u").style.fontWeight = "900";
        teamListArrR2.push(teamListArrR1[0])
    }
    else 
    {
        document.getElementById("r1g1l").innerHTML = teamListArrR1[1].name + "   3" ;
        document.getElementById("r1g1u").innerHTML = teamListArrR1[0].name + "   " + (3+winner);
        document.getElementById("r1g1l").style.fontWeight = "900";
        teamListArrR2.push(teamListArrR1[1])
    }
    winner= returnGame();
    console.log(winner);
    if (winner > 0)
    {
        document.getElementById("r1g2u").innerHTML = teamListArrR1[2].name + "   3" ;
        document.getElementById("r1g2l").innerHTML = teamListArrR1[3].name + "   " + (3-winner);
        document.getElementById("r1g2u").style.fontWeight = "900";
        teamListArrR2.push(teamListArrR1[2])
    }
    else 
    {
        document.getElementById("r1g2l").innerHTML = teamListArrR1[3].name + "   3" ;
        document.getElementById("r1g2u").innerHTML = teamListArrR1[2].name + "   " + (3+winner);
        document.getElementById("r1g2l").style.fontWeight = "900";
        teamListArrR2.push(teamListArrR1[3])
    }
    winner= returnGame();
    console.log(winner);
    if (winner > 0)
    {
        document.getElementById("r1g3u").innerHTML = teamListArrR1[4].name + "   3" ;
        document.getElementById("r1g3l").innerHTML = teamListArrR1[5].name + "   " + (3-winner);
        document.getElementById("r1g3u").style.fontWeight = "900";
        teamListArrR2.push(teamListArrR1[4])
    }
    else 
    {
        document.getElementById("r1g3l").innerHTML = teamListArrR1[5].name + "   3" ;
        document.getElementById("r1g3u").innerHTML = teamListArrR1[4].name + "   " + (3+winner);
        document.getElementById("r1g3l").style.fontWeight = "900";
        teamListArrR2.push(teamListArrR1[5])
    }
    winner= returnGame();
    console.log(winner);
    if (winner > 0)
    {
        document.getElementById("r1g4u").innerHTML = teamListArrR1[6].name + "   3" ;
        document.getElementById("r1g4l").innerHTML = teamListArrR1[7].name + "   " + (3-winner);
        document.getElementById("r1g4u").style.fontWeight = "900";
        teamListArrR2.push(teamListArrR1[6])
    }
    else 
    {
        document.getElementById("r1g4l").innerHTML = teamListArrR1[7].name + "   3" ;
        document.getElementById("r1g4u").innerHTML = teamListArrR1[6].name + "   " + (3+winner);
        document.getElementById("r1g4l").style.fontWeight = "900";
        teamListArrR2.push(teamListArrR1[7])
    }
    //Start Round 2
    winner= returnGame();
    console.log(winner);
    if (winner > 0)
    {
        document.getElementById("r2g1u").innerHTML = teamListArrR2[0].name + "   3" ;
        document.getElementById("r2g1l").innerHTML = teamListArrR2[1].name + "   " + (3-winner);
        document.getElementById("r2g1u").style.fontWeight = "900";
        teamListArrR3.push(teamListArrR2[0])
    }
    else 
    {
        document.getElementById("r2g1l").innerHTML = teamListArrR2[1].name + "   3" ;
        document.getElementById("r2g1u").innerHTML = teamListArrR2[0].name + "   " + (3+winner);
        document.getElementById("r2g1l").style.fontWeight = "900";
        teamListArrR3.push(teamListArrR2[1])
    }
    winner= returnGame();
    console.log(winner);
    if (winner > 0)
    {
        document.getElementById("r2g2u").innerHTML = teamListArrR2[2].name + "   3" ;
        document.getElementById("r2g2l").innerHTML = teamListArrR2[3].name + "   " + (3-winner);
        document.getElementById("r2g2u").style.fontWeight = "900";
        teamListArrR3.push(teamListArrR2[2])
    }
    else 
    {
        document.getElementById("r2g2l").innerHTML = teamListArrR2[3].name + "   3" ;
        document.getElementById("r2g2u").innerHTML = teamListArrR2[2].name + "   " + (3+winner);
        document.getElementById("r2g2l").style.fontWeight = "900";
        teamListArrR3.push(teamListArrR2[3])
    }
    // Start round 3
    if (winner > 0)
    {
        document.getElementById("r3g1u").innerHTML = teamListArrR3[0].name + "   3" ;
        document.getElementById("r3g1l").innerHTML = teamListArrR3[1].name + "   " + (3-winner);
        document.getElementById("r3g1u").style.fontWeight = "900";
        document.getElementById("winner").innerHTML = teamListArrR3[0].name;
        document.getElementById("winner").style.fontWeight = "1000";
    }
    else 
    {
        document.getElementById("r3g1l").innerHTML = teamListArrR3[1].name + "   3" ;
        document.getElementById("r3g1u").innerHTML = teamListArrR3[0].name + "   " + (3+winner);
        document.getElementById("r3g1l").style.fontWeight = "900";
        document.getElementById("winner").innerHTML = teamListArrR3[1].name;
        document.getElementById("winner").style.fontWeight = "1000";
    }
}