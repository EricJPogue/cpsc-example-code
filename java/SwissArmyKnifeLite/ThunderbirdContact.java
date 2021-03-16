/******************************************************************************
 * Copyright (C) 2020 Eric Pogue.
 * 
 * This file is a stand-alone library licensed under the BSD-3-Clause
 * 
 * You are free to reuse the modified or unmodified version of this file in 
 * your projects as long as you give credit to the library in your source code.
 * 
 *****************************************************************************/

class ThunderbirdContact extends HttpRequest implements Runnable {
	private String firstName;
	private String lastName;
	private int seatLocation; 

	ThunderbirdContact(String urlIn) {
		super(urlIn);

		firstName = "";
		lastName = "";
		seatLocation = 0;

		// Todo: Add additional fields. 
	}

	public Boolean Load() {
		Boolean returnValue = false;
		System.out.println("Loading: " + requestURL);
		if (super.readURL()) {
			Parse(); 
			returnValue = true;
		}

		return returnValue;
	}

	public void Parse() {
		for (String s : urlContent) {
			String[] subString = s.split("\"");

			// Todo: Parse for additional fields. 
			if (subString.length > 3) {
				if (subString[1].equals("firstName")) {
					firstName = subString[3];
				}
				if (subString[1].equals("lastName")) {
					lastName = subString[3];
				}
				if (subString[1].equals("seatLocation")) {
					try {
						seatLocation = 0; 
						if (!subString[3].equals("")) {
							seatLocation = Integer.parseInt(subString[3]);
						}
					} 
					catch (Exception e) {
						System.out.println("Exception: " + e);
					}
				}
			}
		}	
	}

	public void Validate() {
		if (urlContent.size() < 1) {
			System.out.println("Validating: " + requestURL);
			System.out.println("	**Failed**: No content loaded\n");
			return; // Returning from the middle of a method is controversial.
		}

		// Todo: Add author's name and email address to failed messages. 
		if (firstName.length() == 0) {
			System.out.println("Validating: " + requestURL);
			System.out.println("	**Failed**: First Name (\"firstName\") required but not found\n\n");
			System.out.println(this);
		} else if (lastName.length() == 0) {   
			System.out.println("Validating: " + requestURL);
			System.out.println("	**Failed**: Last Name (\"lastName\") required but not found\n\n");
			System.out.println(this);		  
		} else {
			System.out.println("Validating: " + requestURL + "... Passed!");
		}
	}

	public String toString() {
		// Todo: Add additional fields to returnString. 
		String returnString = "firstName: " + firstName + "\n";
		returnString = returnString + "lastName: " + lastName + "\n";
		returnString = returnString + "seatNumber: " + seatLocation + "\n";
		returnString = returnString + super.toString();

		return returnString;
	}

	public void run() {
		Load();
	}
}