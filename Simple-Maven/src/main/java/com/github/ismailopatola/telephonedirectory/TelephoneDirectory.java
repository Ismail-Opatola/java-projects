package com.github.ismailopatola.telephonedirectory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class TelephoneDirectory {
	private Scanner scanner;
	Database db;
	
	String firstname;
	String lastname;
	String phone;
	
	Helpers helpers = new Helpers();
	
	/**
	 * constructor
	 */
	TelephoneDirectory() {
		// initialize scanner
		scanner = new Scanner(System.in);
		// initialize database
		db = new Database("lib/db.json");
		
		sendFeedback("[########] Execute - Launch Telephone Directory App");
		sendFeedback("[########] Done!");
		
		askQuestion();
	}

	/**
	 * request user actions and listen for response
	 */
	private void askQuestion() {

		while (true) {

			System.out.println("\nWhat do you want to do? Enter a Key...");
			System.out.print("(H)elp \n(N)ew Contact \n(L)ist \n(F)ind \n(Q)uit \n> ");
			
			char response = Character.toUpperCase(scanner.nextLine().charAt(0));
			
			switch (response) {
			case 'H':
				help();
				break;
			case 'N':
				newContact();
				break;
			case 'L':
				list();
				break;
			case 'D':
				find();
				break;
			case 'Q':
				quit();
				break;

			default:
				sendFeedback("Not a valid answer");
				break;
			}
			
		}

	}

	/**
	 * Exit application
	 */
	private void quit() {
		sendFeedback("[########] Execute - Stop Application");
		sendFeedback("[########] Done!");
		System.exit(0);
	}

	/**
	 * find a contact
	 */
	private void find() {
				
	}

	/**
	 * list all contacts
	 */
	private void list() {
		try {
			JSONArray contactList = db.getAll();
			// sort contact list
			Comparator<Object> c = (s1, s2) -> helpers.compare((JSONObject) s1, (JSONObject) s2);
			contactList.sort(c);
			// parse and print contact list
			helpers.forEachWithCounter(contactList, (i, contact) -> helpers.parseContactObject(i, (JSONObject) contact));
			
		} catch (Exception e) {
			sendFeedback(e.getMessage());
		}
	}


	/**
	 * create a new contact
	 */
	private void newContact() {
		requestNewContactDetails();
				
		try {	
			// create new contact
//			Contact contact = new Contact(firstname, lastname, phone);
			JSONObject contact = new JSONObject();
			contact.put("firstname", firstname);
			contact.put("lastname", lastname);
			contact.put("phone", phone);
			
			// save to database
			db.create(contact);
			sendFeedback("sucessfully added to Telephone Directory!");
		} catch (Exception e) {
			e.printStackTrace();
			sendFeedback(e.getMessage());
		}
	}

	private void requestNewContactDetails() {
		sendFeedback("Enter a New Contact Details>");
		
		while (firstname == null || firstname.isBlank()) {
			sendFeedback("Enter Firstname> ");		
			firstname = scanner.nextLine();			
		}
		
		while (lastname == null || lastname.isBlank()) {
			sendFeedback("Enter Lastname> ");
			lastname = scanner.nextLine();			
		}
		
		while (phone == null || phone.length() != 11) {
			sendFeedback("Enter Phone Number> ");
			sendFeedback("Phone No. must be (11) digits> ");
			phone = scanner.nextLine();					
		}
	}

	/**
	 * Displays help about Telephone Directory cmdlets
	 */
	private void help() {
		/**
		 * stream help.txt to console
		 */
		try {
			FileReader reader = new FileReader("lib/help.txt");
			int data = reader.read(); // stream returns -1 if empty
			while(data != -1) {
				System.out.print((char)data);
				data = reader.read();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 	
	}
	
	/**
	 * A wrapper arround System.out.println. 
	 * Prints string data to the console
	 * @param data
	 */
	void sendFeedback(String data) {
		System.out.println(data);			
	}

}
