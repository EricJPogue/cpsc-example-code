console.log("Starting Murder Mystery..");

//User presses start
var audio = new Audio('soundtrack.mp3');
audio.loop = true;

// Generates a victim
const victims = ['Alice', 'Bob', 'Charlie', 'Daisy', 'Eve'];
const randomInt = Math.floor(Math.random() * victims.length);
const victim = victims[randomInt];
console.log("Victim: " + victim);

// Generates a killer
const killers = ['John', 'Jane', 'Eric', 'Mike', 'Emily'];
const randomInte = Math.floor(Math.random() * victims.length);
const killer = killers[randomInte];
console.log("Killer: " + killer);

// Generates a weapon
const weapons = ['hand gun', 'car', 'kitchen knife', 'poisoned drink'];
const randomInteg = Math.floor(Math.random() * weapons.length);
const weapon = weapons[randomInteg];
console.log("Weapon: " + weapon);

function type(input, HTMLid) {
    const text = input;
    
    // Set the delay between each character in milliseconds
    const delay = 100;
    
    // Initialize the index of the next character to be displayed
    let i = 0;
    
    // Use the setInterval() function to display each character of the text with the specified delay
    const interval = setInterval(function() {
      // Get the next character in the text
      const char = text.charAt(i);
    
      // Check if the character is a space
      if (char === " ") {
        // If the character is a space, add a non-breaking space to the page
        document.getElementById(HTMLid).innerHTML += "&nbsp;";
      } else {
        // If the character is not a space, add the character to the page
        document.getElementById(HTMLid).innerHTML += char;
      }
    
      // Increment the index of the next character to be displayed
      i++;
    
      // Check if all characters have been displayed
      if (i >= text.length) {
        // If all characters have been displayed, clear the interval
        clearInterval(interval);
      }
    }, delay);
}

function handleKeydown(event) {
    // Check if the key pressed was the spacebar
    if (event.key === ' ') {
        // Do something here
        console.log('The user has initiated the intro!');
        audio.play();
        document.getElementById('titleLogo').classList.add('hidden')
        document.getElementById('titleText').classList.add('hidden')
        document.getElementById("credit").classList.remove("hidden")
        type("Developed by Ryan Hinkle", "credit")

        function intro1() {
            console.log("Typing intro one")
            document.getElementById("intro1").classList.remove("hidden")
            type("You are a detective investigating a murder case.", "intro1")
        }

        function intro2() {
            console.log("Typing intro two")
            document.getElementById("intro2").classList.remove("hidden")
            type("At the scene, you find a body lying on the ground.", "intro2")
        }

        function intro3() {
            console.log("Typing intro three")
            document.getElementById("intro3").classList.remove("hidden")
            type("It is up to you to solve the case.", "intro3")
        }

        function intro4() {
            console.log("Typing intro four")
            document.getElementById("intro4").classList.remove("hidden")
            type("The victim's name is " + victim + ".", "intro4")
        }

        function intro5(phrase) {
            console.log("Typing intro five")
            document.getElementById("intro5").classList.remove("hidden")
            type(phrase, "intro5")
        }

        let pronoun = ""

        if (victim == "Alice" || victim == "Daisy" || victim == "Eve") {
            pronoun = "She"
        } else if (victim == "Bob" || victim == "Charlie") {
            pronoun = "He"
        }

        function intro6() {
            console.log("Typing intro six")
            document.getElementById("intro6").classList.remove("hidden")
            type(pronoun + " was murdered with a " + weapon + ".", "intro6")
        }

        function intro7() {
            console.log("Showing intro seven")
            if (victim == "Alice" || victim == "Daisy" || victim == "Eve") {
                document.getElementById("femaleLogo").classList.remove("hidden")
            } else if (victim == "Bob" || victim == "Charlie") {
                document.getElementById("maleLogo").classList.remove("hidden")
            }
            document.getElementById("weaponLogo").classList.remove("hidden")
            document.getElementById("victimLogo").classList.remove("hidden")
            document.getElementById("victimName").innerHTML = victim
            document.getElementById("victimName").classList.remove("hidden")

            if (weapon == "hand gun") {
                document.getElementById("weaponSprite").src = "gunLogo.png"
            } else if (weapon == "car") {
                document.getElementById("weaponSprite").src = "carLogo.png"
            } else if (weapon == "kitchen knife") {
                document.getElementById("weaponSprite").src = "knifeLogo.png"
            } else if (weapon == "poisoned drink") {
                document.getElementById("weaponSprite").src = "poisonLogo.png"
            } 
            document.getElementById("weaponSprite").classList.remove("hidden")

        }
    
        setTimeout(intro1, 5000) //You're a detective
        setTimeout(intro2, 12000) //You arrive to the scene
        setTimeout(intro3, 19000) //Up to you
        setTimeout(intro4, 26000) //Victim
        //Victim description
        if (victim == "Alice") {
            setTimeout(function() {
                intro5("Alice was a 30 year old high school teacher.");
            }, 32500);
        } else if (victim == "Bob") {
            setTimeout(function() {
                intro5("Bob was a 67 year old window salesman.");
            }, 32500);
        } else if (victim == "Charlie") {
            setTimeout(function() {
                intro5("Charlie was a 17 year old pizza delivery driver.");
            }, 32500);
        } else if (victim == "Daisy") {
            setTimeout(function() {
                intro5("Daisy was a 41 year old pediatric nurse.");
            }, 32500);
        } else if (victim == "Eve") {
            setTimeout(function() {
                intro5("Eve was a 26 year old dance instructor.");
            }, 32500);
        }
        setTimeout(intro6, 40000) //Weapon
        setTimeout(intro7, 47000) //Gender sillhoutte

        function suspects1(phrase) {
            console.log("Typing suspects")
            document.getElementById("suspects1").classList.remove("hidden")
            type(phrase, "suspects1")
        }

        //Place of murder and scenario
        if (victim == "Alice") {
            setTimeout(function() {
                suspects1("Alice was murdered in her classroom after hours.");
            }, 54000);
        } else if (victim == "Bob") {
            setTimeout(function() {
                suspects1("Bob was murdered in his car on the way to an appointment.");
            }, 54000);
        } else if (victim == "Charlie") {
            setTimeout(function() {
                suspects1("Charlie was murdered at a customer's doorstep.");
            }, 54000);
        } else if (victim == "Daisy") {
            setTimeout(function() {
                suspects1("Daisy was murdered in an office building elevator.");
            }, 54000);
        } else if (victim == "Eve") {
            setTimeout(function() {
                suspects1("Eve was murdered in the break room of her dance studio.");
            }, 54000);
        }

        function suspects2() {
            console.log("Typing suspects")
            document.getElementById("suspects2").classList.remove("hidden")
            type("The suspects are listed as follows:", "suspects2")
        }

        function suspects3() {
            console.log("Typing suspects")
            document.getElementById("suspects3").classList.remove("hidden")
            type("John, a 32 year old corporate businessman. Motive: Money", "suspects3")
        }

        function suspects4() {
            console.log("Typing suspects")
            document.getElementById("suspects4").classList.remove("hidden")
            type("Jane, a 20 year old college student. Motive: Jealousy", "suspects4")
        }

        function suspects5() {
            console.log("Typing suspects")
            document.getElementById("suspects5").classList.remove("hidden")
            type("Eric, a 48 year old real estate agent. Motive: Property", "suspects5")
        }

        function suspects6() {
            console.log("Typing suspects")
            document.getElementById("suspects6").classList.remove("hidden")
            type("Mike, a 52 year old janitor. Motive: Anger", "suspects6")
        }

        function suspects7() {
            console.log("Typing suspects")
            document.getElementById("suspects7").classList.remove("hidden")
            type("Emily, a 29 year old stay at home mom. Motive: Self Defense", "suspects7")
        }

        setTimeout(suspects2, 61000)
        setTimeout(suspects3, 68000)
        setTimeout(suspects4, 75000)
        setTimeout(suspects5, 82000)
        setTimeout(suspects6, 89000)
        setTimeout(suspects7, 96000)

        function suspects8() {
            document.getElementById("suspects8").innerHTML = "[please select the perpetrator]"
            document.getElementById("suspects8").classList.remove("hidden")
        }

        function suspects9() {
            document.getElementById("mikeLogo").classList.remove("hidden")
        }

        function suspects10() {
            document.getElementById("janeLogo").classList.remove("hidden")
        }

        function suspects11() {
            document.getElementById("ericLogo").classList.remove("hidden")
        }

        function suspects12() {
            document.getElementById("johnLogo").classList.remove("hidden")
        }

        function suspects13() {
            document.getElementById("emilyLogo").classList.remove("hidden")
        }

        setTimeout(suspects8, 106000)
        setTimeout(suspects9, 106000)
        setTimeout(suspects10, 106000)
        setTimeout(suspects11, 106000)
        setTimeout(suspects12, 106000)
        setTimeout(suspects13, 106000)

        // Remove the event listener
        window.removeEventListener('keydown', handleKeydown);
    }
}
  
// Add the event listener
window.addEventListener('keydown', handleKeydown); 
let userSelect = ""

function userJohn() {
    userSelect = "John"
    console.log(userSelect)
    endScreen()
}

function userJane() {
    userSelect = "Jane"
    console.log(userSelect)
    endScreen()
}

function userMike() {
    userSelect = "Mike"
    console.log(userSelect)
    endScreen()
}

function userEric() {
    userSelect = "Eric" 
    console.log(userSelect)
    endScreen()
}

function userEmily() {
    userSelect = "Emily"
    console.log(userSelect)
    endScreen()
}

function endScreen() {
    document.getElementById("suspects8").classList.add("hidden")
    document.getElementById("johnLogo").classList.add("hidden")
    document.getElementById("janeLogo").classList.add("hidden")
    document.getElementById("ericLogo").classList.add("hidden")
    document.getElementById("mikeLogo").classList.add("hidden")
    document.getElementById("emilyLogo").classList.add("hidden")

    if (userSelect == killer) {
        console.log("The user selected the correct answer")
        document.getElementById("correct").classList.remove("hidden")
        type("You have solved the case! " + killer + " was the killer.", "correct")
        document.getElementById("playAgain").innerHTML = "[press enter to play again]"
        document.getElementById("playAgain").classList.remove("hidden")
    } else {
        console.log("The user selected the wrong answer")
        document.getElementById("wrong").classList.remove("hidden")
        type("You blew the case! " + killer + " was the killer.", "wrong")
        document.getElementById("playAgain").innerHTML = "[press enter to play again]"
        document.getElementById("playAgain").classList.remove("hidden")
    }

    document.addEventListener('keydown', function(event) {
        if (event.key === 'Enter') {
            location.reload();
        }
      });   
}