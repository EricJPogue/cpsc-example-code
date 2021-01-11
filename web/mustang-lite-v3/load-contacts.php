<?php
    header("Content-Type: application/json; charset=UTF-8");
    $myfiler = fopen("contacts.json", "r") or die("Unable to open file to read!");
    $obj = fread($myfiler,filesize("contacts.json"));
    fclose($myfiler);
    echo $obj;
?>