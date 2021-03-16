var obj;
var role;
var increase = true;
const proxyurl = "https://cors-anywhere.herokuapp.com/";
var playerId = 19136;
const token = "?token=wPrHIPK-H1sa139CRk3ujlb7vZw8oPfvNHueoDcBSNnq6n4T6b0";
function intro(){
    

    var indexRequest = new XMLHttpRequest();
    indexRequest.open('GET', proxyurl+'https://api.pandascore.co/ow/players/'+ playerId+'/stats?token=wPrHIPK-H1sa139CRk3ujlb7vZw8oPfvNHueoDcBSNnq6n4T6b0');
   
    indexRequest.onload = function() {
        console.log("Panda Response:" + indexRequest.responseText);
        
        var niceText = JSON.parse(indexRequest.responseText);
        if(niceText.error === "Record not found")
        {
         
          if(increase){
            decreaseId();
          }
          else{
            increaseId();
          }
        }
        var name = niceText.first_name + " " + niceText.last_name;
        var obj = JSON.stringify(niceText, null, 4);
        role = niceText.role;
        setRoleInfo(niceText);
        console.log(niceText.current_team);
        
        if(niceText.current_team != null)
        {
            document.getElementById("team").innerHTML = "Team Name: " + niceText.current_team.name;
        }
        else{
            document.getElementById("team").innerHTML = "Team Name: Currently not playing for a team";
        }
        document.getElementById("name").innerHTML = name;
        document.getElementById("pName").innerHTML = "Player Name: " + niceText.name;
        document.getElementById("hometown").innerHTML = "Home Town: " + niceText.hometown;
        document.getElementById("birth").innerHTML = "Birthday: " + niceText.birthday;
        document.getElementById("role").innerHTML = "Primary Role: " + role;
        document.getElementById("hero").innerHTML = "Most played hero: " + niceText.favorite_heroes[0].hero.name;
        document.getElementById('playerImage').src= niceText.image_url;
        console.log("ContactURLArray: " + JSON.stringify(niceText));
    }
    indexRequest.send();
}
function changeTab(evt, tabName) {
    // Declare all variables
    var i, tabcontent, tablinks;
  
    // Get all elements with class="tabcontent" and hide them
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
      tabcontent[i].style.display = "none";
    }
  
    // Get all elements with class="tablinks" and remove the class "active"
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
      tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
  
    // Show the current tab, and add an "active" class to the button that opened the tab
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
  }

  function setRoleInfo(niceText)
  {
    var winRate = Math.round((niceText.stats.totals.map_won/ (niceText.stats.totals.map_won+niceText.stats.totals.map_lost+niceText.stats.totals.map_draw))*100);

    document.getElementById("roleH").innerHTML = role + " Stats";
    document.getElementById("roleHL").innerHTML = "Last Game Stats";
    var hList = "";
        niceText.last_games[0].heroes.forEach(element => hList = hList + element.name + " ");
        document.getElementById("primaryInfoAL").innerHTML = "Played against: " + niceText.last_games[0].opponent.name;
        document.getElementById("primaryInfoBL").innerHTML = "Played Heroes: " + hList;
        document.getElementById("primaryInfoCL").innerHTML = "Kills: " + niceText.last_games[0].kills;
        document.getElementById("secondaryInfoAL").innerHTML = "Deaths: " + niceText.last_games[0].deaths
        document.getElementById("secondaryInfoBL").innerHTML = "Ultimates: " + niceText.last_games[0].ultimate;
      if (role==="Damage")
      {
        document.getElementById("primaryInfoA").innerHTML = "Eliminations per Game: " + niceText.stats.per_game_averages.eliminations;
        document.getElementById("primaryInfoB").innerHTML = "Kills per Game: " + niceText.stats.per_game_averages.kills;
        document.getElementById("primaryInfoC").innerHTML = "Deaths per Game: " + niceText.stats.per_game_averages.deaths
        document.getElementById("secondaryInfoA").innerHTML = "Damage dealt per game: " + niceText.stats.per_game_averages.damage_done;
        document.getElementById("secondaryInfoB").innerHTML = "Ultimates per game: " + niceText.stats.per_game_averages.ultimates;
        document.getElementById("secondaryInfoC").innerHTML = "Win Rate: " + winRate+"%";

        
      }
      else if (role ==="Tank")
      {
        document.getElementById("secondaryInfoB").innerHTML = "Eliminations per Game: " + niceText.stats.per_game_averages.eliminations;
        document.getElementById("primaryInfoB").innerHTML = "Kills per Game: " + niceText.stats.per_game_averages.kills;
        document.getElementById("primaryInfoC").innerHTML = "Deaths per Game: " + niceText.stats.per_game_averages.deaths
        document.getElementById("secondaryInfoA").innerHTML = "Damage dealt per game: " + niceText.stats.per_game_averages.damage_done;
        document.getElementById("primaryInfoA").innerHTML = "Ultimates per game: " + niceText.stats.per_game_averages.ultimates;
        document.getElementById("secondaryInfoC").innerHTML = "Win Rate: " + winRate+"%";
      }
      else if (role ==="Support")
      {
        document.getElementById("secondaryInfoB").innerHTML = "Eliminations per Game: " + niceText.stats.per_game_averages.eliminations;
        document.getElementById("primaryInfoB").innerHTML = "Kills per Game: " + niceText.stats.per_game_averages.kills;
        document.getElementById("primaryInfoC").innerHTML = "Deaths per Game: " + niceText.stats.per_game_averages.deaths
        document.getElementById("secondaryInfoA").innerHTML = "Healing per game: " + niceText.stats.per_game_averages.healing_done;
        document.getElementById("primaryInfoA").innerHTML = "Ultimates per game: " + niceText.stats.per_game_averages.ultimates;
        document.getElementById("secondaryInfoC").innerHTML = "Win Rate: " + winRate+"%";
      }
  }
  function increaseId()
  {
    playerId = playerId+1;
    increase = true
    intro();
  }
  function decreaseId()
  {
    playerId = playerId-1;
    increase = false
    intro();
  }