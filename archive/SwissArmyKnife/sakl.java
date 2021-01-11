/*******************************************************************************
 * Copyright (C) 2019 Eric Pogue. All rights reserved. 
 * 
 * This file is part of the SwissArmyKnifeLite (sakl) project.
 * 
 * This file can not be copied and/or distributed without 
 * the express permission of Eric Pogue
 * 
 * This application uses the open source component HttpRequest.java
 ******************************************************************************/

public class sakl {
	public static void main(String[] args) {
		System.out.println("");
		if (args.length < 1) {
			// Process no arguments.
			System.out.println("This application requires at least one argument. Utilize the \"-Help\" parameter for more "
				+"information.");
			Help.printHelp();		 
		} 
		else if (args[0].equalsIgnoreCase("-Help")) {
			System.out.println("Executing Help...");
			Help.printHelp();		  
		} 
		else if (args[0].equalsIgnoreCase("-HttpRequest")) {
			System.out.println("Executing HttpRequest...");
			if (args.length <2) {
				System.out.println("The -HttpRequest function requires a valid URL as the second parameter.");
			} else {
				String URL = args[1];
				HttpRequest request = new HttpRequest();
				if (request.readURL(URL)) {
					System.out.println(request);
				}
			}
		}
		else if (args[0].equalsIgnoreCase("-HttpRequestIndex")) {
			 System.out.println("Executing HttpRequestIndex...");	
			if (args.length != 2) {
				System.out.println("[[Your Error message here.]]");
			} else {
				String indexURL = args[1];
				HttpRequest requestIndex = new HttpRequest();
				if (requestIndex.readURL(indexURL)) {
					System.out.println(requestIndex);
				}
			}
		}
		else if (args[0].equalsIgnoreCase("-DoMagicStuff")) {
			ThunderbirdModel model = new ThunderbirdModel();
			model.LoadIndex();
			model.LoadContacts();
			System.out.println(model);
		}

		System.out.println("");
	}
} 