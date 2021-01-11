// Try changing the capitalization of the the function name.
// Try changing "x" to "X" in the difference calculation.

function RollSixSidedDice() {
    document.getElementById("dice").value = Math.floor(Math.random()*6) + 1;
}

function DoCalculations() {
    x = document.getElementById("xID").value;
    y = document.getElementById("yID").value;
    console.log("x="+x+" and y="+y);

    x = Number(x);
    y = Number(y);

    sum = x+y;
    difference = x-y;
    product = x*y;
    quotient = x/y;
    test = "2" + 5;

    mathResults = "sum="+sum+"<br>";
    mathResults += "difference="+difference+"<br>";
    mathResults += "product="+product+"<br>";
    mathResults += "quotient="+quotient+"<br>";
    mathResults += "test="+test+"<br>";
    document.getElementById("mathResultsID").innerHTML = mathResults;

    var a = 7;
    var b = 2;
    if (a  == b || a > 5) {
        console.log("123");
        if (b > 3 && a < 8) {
            console.log("456");
        } else {
            console.log("789");
        }
        if (a+b > 9)
        console.log("10");
    }
}