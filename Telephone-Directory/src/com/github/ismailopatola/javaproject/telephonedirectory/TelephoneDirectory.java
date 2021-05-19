package com.github.ismailopatola.javaproject.telephonedirectory;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TelephoneDirectory {
	private Scanner scanner;
	Database db;
	
	String firstname;
	String lastname;
	int phone;
	
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
			ContactDetails[] contacts =  (Contact[]) db.getAll();
			
			for (int i = 0; i < contacts.length; i++) {
				System.out.println(
						"(" + i + 1 + ")" 
						+ " " 
						+ "Firstname: " 
						+ contacts[i].getFirstname() 
						+ " " 
						+ "Lastname: " 
						+ contacts[i].getLastname() 
						+ " " + "Phone: " 
						+ contacts[i].getPhone());
			}
			
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
			Contact contact = new Contact(firstname, lastname, phone);
			// save to database
			db.create(contact);
			sendFeedback("sucessfully added to Telephone Directory!");
		} catch (Exception e) {			
			sendFeedback(e.getMessage());
		}
	}

	private void requestNewContactDetails() {
		sendFeedback("Enter a New Contact Details>");
		
		while (firstname.isBlank()) {
			sendFeedback("Enter Firstname> ");		
			firstname = scanner.next();			
		}
		
		while (lastname.isBlank()) {
			sendFeedback("Enter Lastname> ");
			lastname = scanner.next();			
		}
		
		while (String.valueOf(phone).length() != 11) {
			sendFeedback("Enter Phone Number> ");
			sendFeedback("Phone No. must be (11) digits> ");
			phone = scanner.nextInt();					
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
