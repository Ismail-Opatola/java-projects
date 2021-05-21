package com.telephonedirectorypackage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class TelephoneDirectory {

	private Scanner scanner;
	Database db;
	
	String firstname;
	String lastname;
	String phone;
	
	Helpers helpers;
		
	/**
	 * constructor
	 */
	TelephoneDirectory() {
		helpers = new Helpers();
		// initialize scanner
		scanner = new Scanner(System.in);
		// initialize database
		db = new Database("lib/db.json");
		
		launchAppStaticFeedback();
		
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
			case 'F':
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
	 * Displays help about Telephone Directory cmdlets
	 */
	private void help() {
		/**
		 * stream help.txt to console
		 */
		try {
			final long startTime = System.currentTimeMillis();

			FileReader reader = new FileReader("lib/help.txt");
			int data = reader.read(); // stream returns -1 if empty
			while(data != -1) {
				System.out.print((char)data);
				data = reader.read();
			}
			reader.close();
			
			final long endTime = System.currentTimeMillis();
			sendExecutionTimeFeedback(startTime, endTime);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 	
	}

	/**
	 * create a new contact
	 */
	private void newContact() {
		requestNewContactDetails();
				
		try {	
			final long startTime = System.currentTimeMillis();

			// create new contact
			Contact contact = new Contact(firstname, lastname, phone);				
			// save to database
			db.create(contact);
			
			final long endTime = System.currentTimeMillis();
			sendExecutionTimeFeedback(startTime, endTime);
			sendFeedback("sucessfully added to Telephone Directory!");
		} catch (Exception e) {
			e.printStackTrace();
			sendFeedback(e.getMessage());
		}
	}

	/**
	 * list all contacts
	 */
	private void list() {
		try {
			final long startTime = System.currentTimeMillis();
			
			ArrayList<Contact> contactList = db.getAll();
			sortAndDisplayData(contactList);			
			
			final long endTime = System.currentTimeMillis();
			sendExecutionTimeFeedback(startTime, endTime);
		} catch (Exception e) {
			sendFeedback(e.getMessage());
		}
	}

	
	/**
	 * find contact by query
	 */
	private void find() {
		final long startTime = System.currentTimeMillis();

		String queryString = requestQuery();
		try {
			ArrayList<Contact> response = db.find(queryString);
			if(response != null) {
				sortAndDisplayData(response);				
			} else {
				sendFeedback("Contact Not Found!");
			}
			
			final long endTime = System.currentTimeMillis();
			sendExecutionTimeFeedback(startTime, endTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Exit application
	 */
	private void quit() {
		killAppStaticFeedback();		
		System.exit(0);
	}

	private void sortAndDisplayData(ArrayList<Contact> contactList) {
		// sort contact list
		Comparator<Contact> c = new Comparator<Contact>() {
			public int compare(Contact s1, Contact s2) {
				return helpers.compare(s1, s2);
			}
		};

		contactList.sort(c);
		
		// parse and print contact list
		helpers.forEachWithCounter(contactList, new BiConsumer<Integer, Contact>() {
			public void accept(Integer i, Contact contact) {
				displayContactDetails(i, contact);
			}
		});
	}
	
	private String requestQuery() {
		String queryString = null;
		while (queryString == null || queryString.isBlank()) {
			sendFeedback("Enter query>");
			sendFeedback("Search by Phone number, Firstname or Lastname>");
			queryString = scanner.nextLine();			
		}
		return queryString;
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
	 * A wrapper arround System.out.println. 
	 * Prints string data to the console
	 * @param data
	 */
	void sendFeedback(String data) {
		System.out.println(data);			
	}
	
	void launchAppStaticFeedback() {
		final long startTime = System.currentTimeMillis();
		System.out.print("Execute - Start Telephone Directory App ");
		System.out.print("[");
		for (int i = 0; i < 25; i++) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("#");
		}
		System.out.print("]\n");
		final long endTime = System.currentTimeMillis();
		sendExecutionTimeFeedback(startTime, endTime);
	}
	
	void killAppStaticFeedback() {
		final long startTime = System.currentTimeMillis();
		System.out.print("Execute - Kill Application ");
		System.out.print("[");
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("#");
		}
		System.out.print("]\n");
		final long endTime = System.currentTimeMillis();
		sendExecutionTimeFeedback(startTime, endTime);
	}
	
	void sendExecutionTimeFeedback(long startTime, long endTime) {
		sendFeedback("\nDone in " + (endTime - startTime) + "s.");
	}
	
	/**
	 * parse and print contact object to console
	 * @param i
	 * @param contact
	 */
    public void displayContactDetails(int i, Contact contact) {
    	String firstname = (String) contact.getFirstname();    
    	String lastname = (String) contact.getLastname();    
    	String phone = (String) contact.getPhone();    

    	System.out.println(
				"(" + (i+1) + ")" 
				+ " " 
				+ "Firstname: " 
				+ firstname 
				+ " " 
				+ "Lastname: " 
				+ lastname 
				+ " " + "Phone: " 
				+ phone);
    }
}
