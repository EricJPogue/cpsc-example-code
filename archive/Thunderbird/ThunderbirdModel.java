/******************************************************************************
 * Copyright (C) 2019 Eric Pogue.
 * 
 * This file is licensed under the BSD-3-Clause
 * 
 * You may use any part of the file as long as you give credit in your 
 * source code.
 * 
 *****************************************************************************/

 import java.util.ArrayList;

class ThunderbirdModel extends HttpRequest {
    // Todo: Add the URL of the index file for your class here.
    // Hint: Consider using "https://thunderbird-index.azurewebsites.net/w0a6zk195d.json"

    private String indexURL = "[[YOUR-URL-HERE]]";
    
    private ArrayList<ThunderbirdContact> contactList;

    ThunderbirdModel() {
        contactList = new ArrayList<ThunderbirdContact>();
    }

    public Boolean LoadIndex() {
        Boolean returnValue = false;
        if (readURL(indexURL)) {
            // Look through the index JSON file for each URL and then create a new Contact object.
            for (String line : urlContent) {
                String[] subString = line.split("\"");
                // The substring after the 11 double-quote should be the URL.
                if (subString.length >= 11) {
                    if (subString[11].indexOf("https://") > -1) {
                        contactList.add(new ThunderbirdContact(subString[11]));

                        // Todo: We must have added at least one ThunderbirdContact to be successful. Verify 
                        //     that at least one was added and set the return value to false if no items were
                        //     added. 
                        returnValue = true;
                    }
                }
            }            
        }
        
        return returnValue; 
    }

    public void LoadContacts() {
        long start = System.currentTimeMillis();
        int contactsLoaded = 0;
        for (ThunderbirdContact hrC : contactList) {
            hrC.Load();
            contactsLoaded++;
        }

        System.out.println("Contacts Loaded: " + contactsLoaded);
        System.out.println("LoadContacts Elapsed Time: " + (System.currentTimeMillis()-start) + " ms\n");
    }

    public void LoadContactsThreaded() {
        long start = System.currentTimeMillis(); 
        int contactsLoaded = 0;

        ArrayList<Thread> threadList = new ArrayList<Thread>();
        for (ThunderbirdContact hrC : contactList) {
            threadList.add(new Thread(hrC));
        }        

        for (Thread t: threadList) {
            t.start();
            contactsLoaded++;
        }

        try {
            for (Thread t: threadList) {
                t.join();
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

        System.out.println("Contacts Loaded: " + contactsLoaded);
        System.out.println("LoadContacts Elapsed Time = " + (System.currentTimeMillis()-start) + " ms\n");
    }

    public void ValidateContacts() {
        long start = System.currentTimeMillis();
        System.out.println("Validating Contacts:");
        for (ThunderbirdContact hrC : contactList) {
            hrC.Validate();
        }
        System.out.println("ValidateContacts Elapsed Time = " + (System.currentTimeMillis()-start) + " ms\n");
    }
    
    public String toString() {
        // The super class contains the Index of contacts.
        String returnString = "Index:\n" + super.toString();

        returnString = returnString + "\nPrinting Contacts:\n";
        for (ThunderbirdContact contact : contactList) {
            returnString = returnString + contact + "\n";
        } 
        return returnString;
    }

    public ThunderbirdContact findContactInSeat(int seat) {
        ThunderbirdContact returnContact = null; 
        for (ThunderbirdContact contact : contactList) {        
            if (contact.getSeat() == seat) {
                returnContact = contact;
            }
        }
        return returnContact; 
    } 
}