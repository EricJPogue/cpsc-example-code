console.log("Starting Murder Mystery..");

//User presses start
document.addEventListener('keydown', function(event) {
    if (event.code == 'Space') {
        console.log("User has iniated startup, soundtrack playing")
        new Audio("soundtrack.mp3").play()
        //window.location = 'instructions.html';
    }
});

window.addEventListener('beforeunload', function(event) {
    new Audio("soundtrack.mp3").play()
});