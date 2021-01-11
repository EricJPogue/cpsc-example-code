// $(function() { } -> $(document).ready(function() { });
// See also "https://stackoverflow.com/questions/7642442/what-does-function-do"
// jQuery (a library built on Javascript) has built in functions that generally required the DOM to be fully rendered before 
//     being called. The syntax for when this is completed is: $(document).ready(function() { ... });

$(function() {
    var availableTutorials  =  [
        "ActionScript",
        "Bootstrap",
        "C",
        "C++",
        "Java",
        "JavaScript",
        "Pascal",
        "Fortran"
    ];
    $( "#automplete-1" ).autocomplete({
        source: availableTutorials
    });
});