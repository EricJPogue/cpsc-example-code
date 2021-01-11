
var contactURLArray = [];
var contactArray = [];
var loadingContact = 0;
var currentContactIndex = 0; 

// Functions
function initApplication() {
    console.log('Mustang v3 Lite - Starting!'); 
    document.getElementById("nameID").value = "";   
    document.getElementById("emailID").value = "";   
    document.getElementById("cityID").value = "";   
    document.getElementById("stateID").value = "";
    document.getElementById("zipID").value = "";  
}

function setStatus(status) {
    document.getElementById("statusID").innerHTML = status;    
}

function zipBlurFunction() {
    ZipToCityState();
}

function importContacts() {
    console.log("importContacts()");
    loadIndexAndContacts();
}

function saveContactsToServer() {
    console.log("saveContactsToServer()");
    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            console.log('Response: ' + this.responseText);
            setStatus(this.responseText)
        }
    };
    xmlhttp.open("POST", "save-contacts.php", true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.send("contacts=" + JSON.stringify(contactArray));   
}

function loadContactsFromServer() {
    console.log("loadContactsFromServer()");

    // Clear the current contacts.
    contactArray.length = 0;

    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            contactArray = JSON.parse(this.responseText);
            setStatus("Loaded contacts (" + contactArray.length + ")");

            currentContactIndex = 0;
            viewCurrentContact()
        }
    };

    xmlhttp.open("GET", "load-contacts.php", true);
    xmlhttp.send();   
}

function logContacts() {
    console.log("ContactArray: ");
    console.log(contactArray);
}

function viewCurrentContact() {
    currentContact = contactArray[currentContactIndex];
    console.log(currentContact);
    document.getElementById("nameID").value = currentContact.preferredName;   
    document.getElementById("emailID").value = currentContact.email;   
    document.getElementById("cityID").value = currentContact.city;   
    document.getElementById("stateID").value = currentContact.state;
    document.getElementById("zipID").value = currentContact.zip;  

    // Todo: Add additional fields.
    document.getElementById("statusID").innerHTML = "Viewing contact " + (currentContactIndex+1) + " of " + contactArray.length;
}

function previous() {
    if (currentContactIndex > 0) {
        currentContactIndex--;
    }
    currentContact = contactArray[currentContactIndex];
    viewCurrentContact();

    // Todo: Disable previous button when currentContactIndex equal to 0.
}

function next() {
    if (currentContactIndex < (contactArray.length-1)) {
        currentContactIndex++;
    }
    currentContact = contactArray[currentContactIndex];
    viewCurrentContact();
    
    // Todo: Disable next button when there is no next item.
    // Todo: Save changed items to contacts array and resort array.
}

function add() {
    console.log('add()**');

    // Todo: Implement add functionality by inserting new element into array.
}

function remove() {
    console.log('remove()');

    // Todo: Implement delete functionality by deleting element from array.
}

function ZipToCityState() {
    var zip = document.getElementById("zipID").value
    console.log("zip:"+zip);

    console.log("function getPlace(zip) { ... }");
    var xhr = new XMLHttpRequest();

    // Register the embedded handler function
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var result = xhr.responseText;
            console.log("ZipToCityState Result:" + result);
            var place = result.split(', ');
            if (document.getElementById("cityID").value == "")
                document.getElementById("cityID").value = place[0];
            if (document.getElementById("stateID").value == "")
                document.getElementById("stateID").value = place[1];
        }
    }
    xhr.open("GET", "zip-to-city-state.php?zip=" + zip);
    xhr.send(null);
}

function loadIndexAndContacts() {
    // Load the Mustang index file.
    var indexRequest = new XMLHttpRequest();
    indexRequest.open('GET', 'https://mustang-index.azurewebsites.net/index.json');
    indexRequest.onload = function() {
        console.log("Index JSON:" + indexRequest.responseText);
        document.getElementById("indexID").innerHTML = indexRequest.responseText;
        contactIndex = JSON.parse(indexRequest.responseText);
        for (i=0; i<contactIndex.length; i++) {
            contactURLArray.push(contactIndex[i].ContactURL);
        }
        console.log("ContactURLArray: " + JSON.stringify(contactURLArray));
        loadContacts();
    }
    indexRequest.send();
}

function loadContacts() {
    // Clear the current contactArray.
    contactArray.length = 0;
    loadingContact = 0;

    // Note that W3C documentation and my experimentation indicate that each XMLHttpRequest callback function must be a 
    // unique instance of a function. A better implmentation would have had an array of callback functions instead of a 
    // recursive call to load
    if (contactURLArray.length > loadingContact) {
        loadNextContact(contactURLArray[loadingContact]);
    }
}

function loadNextContact(URL) {
    console.log("URL: " + URL);
    contactRequest = new XMLHttpRequest();
    contactRequest.open('GET', URL);
    contactRequest.onload = function() {
        var contact = JSON.parse(contactRequest.responseText);
        contactArray.push(contact);

        document.getElementById("contactsID").innerHTML = JSON.stringify(contactArray);
        document.getElementById("statusID").innerHTML = "Loading " + contact.firstName + " " + contact.lastName;

        loadingContact++;
        if (contactURLArray.length > loadingContact) {
            loadNextContact(contactURLArray[loadingContact]);
        }
        else {
            document.getElementById("statusID").innerHTML = "Contacts Loaded (" + contactURLArray.length + ")";
            viewCurrentContact()

            //Todo: Sort contacts array.
        }
    }
    contactRequest.send();
}

