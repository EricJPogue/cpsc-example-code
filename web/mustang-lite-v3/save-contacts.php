<?php
    $contacts = $_POST["contacts"];
    $myfile = fopen("contacts.json", "w") or die("Unable to open file to write!");
    fwrite($myfile, $contacts);
    fclose($myfile);
    echo "Contacts saved";
?>