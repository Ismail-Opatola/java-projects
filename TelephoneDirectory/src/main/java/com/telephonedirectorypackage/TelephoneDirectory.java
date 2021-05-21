package com.telephonedirectorypackage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class TelephoneDirectory {

	private Scanner scanner;
	Database db;
	Helpers helpers;
		
	/**
	 * Telephone Directory constructor
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
			// track code excution time
			final long startTime = System.currentTimeMillis();

			FileReader reader = new FileReader("lib/help.txt");
			int data = reader.read(); // stream returns -1 if empty
			
			displayBlankLine();
			
			// while data is not empty, print stream to console
			while(data != -1) {
				System.out.print((char)data);
				data = reader.read();
			}
			reader.close();
			
			displayBlankLine();
			
			// track code excution time
			final long endTime = System.currentTimeMillis();
			sendExecutionTimeFeedback(startTime, endTime);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 	
	}

	/**
	 * creates a new contact
	 * and save to the database
	 */
	private void newContact() {
				
		try {
			// track code excution time
			final long startTime = System.currentTimeMillis();

			// prompt user for new contact details
			// create new contact object
			Contact contact = requestNewContactDetails();
									
			// save to database
			db.create(contact);
			
			// track code excution time
			final long endTime = System.currentTimeMillis();
			sendExecutionTimeFeedback(startTime, endTime);
			sendFeedback("sucessfully added to Telephone Directory!");
		} catch (Exception e) {
			e.printStackTrace();
			sendFeedback(e.getMessage());
		}
	}

	/**
	 * list all contacts in the Telephone Directory
	 */
	private void list() {
		try {
			// track code excution time
			final long startTime = System.currentTimeMillis();
			
			ArrayList<Contact> contactList = db.getAll();
			sortAndDisplayData(contactList);			
			
			// track code excution time
			final long endTime = System.currentTimeMillis();
			sendExecutionTimeFeedback(startTime, endTime);
		} catch (Exception e) {
			sendFeedback(e.getMessage());
		}
	}

	
	/**
	 * find contact by query<br>
	 * prompts user for:
	 * <ul>
	 * 	<li>query string</li>
	 * 	<li>find exact match</li>
	 * 	<li>find all possible match</li>
	 * </ul>
	 */
	private void find() {
		// track code excution time
		final long startTime = System.currentTimeMillis();

		String queryString = requestQuery();
		Boolean toFindAll = askToFindAllMatch();
		
		try {
			if(!toFindAll) {
				// find exact match
				Contact response = db.find(queryString);
				if(response != null) {
					displayData(response);				
					// TODO: More actions: Update, Delete, Back
				} else {
					displayBlankLine();
					sendFeedback("Contact not found!");
				}				
			} else {
				// find all possible matches
				ArrayList<Contact> response = db.findAll(queryString);
				if(response != null && !response.isEmpty()) {
					sortAndDisplayData(response);				
				} else {
					displayBlankLine();
					sendFeedback("No matches found!");
				}								
			}
			
			// track code excution time
			final long endTime = System.currentTimeMillis();
			sendExecutionTimeFeedback(startTime, endTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * kill or stop running application
	 */
	private void quit() {
		killAppStaticFeedback();		
		System.exit(0);
	}
	/**
	 * sort and display a list of contacts to the console
	 * @param contactList
	 */
	private void sortAndDisplayData(ArrayList<Contact> contactList) {
		// range 0 - Z
		final Map<Character, Boolean> range = generateMapOfRange0ToZ();
		
		// sort contact list by firstname
		Comparator<Contact> c = new Comparator<Contact>() {
			public int compare(Contact s1, Contact s2) {
				return helpers.compare(s1, s2);
			}
		};

		contactList.sort(c);

		displayBlankLine();
		sendFeedback("================ Telephone Directory Result ================");
		displayBlankLine();

		// parse and print contact list
		helpers.forEachWithCounter(contactList, new BiConsumer<Integer, Contact>() {
			public void accept(Integer i, Contact contact) {
				// TODO: grep data to console		
				displayByRange(range, contact);
				displayContactDetails(i, contact);
			}
		});
	}
	
	/**
	 * generate an object map 
	 * <ul>
	 * 	<li>whose keys ranges from 0 to Z char</li> 
	 * 	<li>holds boolean value - true or false</li>
	 * </ul>
	 * @return Map 
	 */
	private Map<Character, Boolean> generateMapOfRange0ToZ() {
		final Map<Character, Boolean> range = new HashMap<Character, Boolean>();
		range.put('A', false);
		range.put('B', false);
		range.put('C', false);
		range.put('D', false);
		range.put('E', false);
		range.put('F', false);
		range.put('G', false);
		range.put('H', false);
		range.put('I', false);
		range.put('J', false);
		range.put('K', false);
		range.put('L', false);
		range.put('M', false);
		range.put('N', false);
		range.put('O', false);
		range.put('P', false);
		range.put('Q', false);
		range.put('R', false);
		range.put('S', false);
		range.put('T', false);
		range.put('U', false);
		range.put('V', false);
		range.put('W', false);
		range.put('X', false);
		range.put('Y', false);
		range.put('Z', false);
		range.put('0', false);
		range.put('1', false);
		range.put('2', false);
		range.put('3', false);
		range.put('4', false);
		range.put('5', false);
		range.put('6', false);
		range.put('7', false);
		range.put('8', false);
		range.put('9', false);
		
		return range;
	}

	/**
	 * track and display range 0 - Z to console
	 * @param range
	 * @param contact
	 */
	private void displayByRange(Map<Character, Boolean> range, Contact contact) {
		// get the first character in firstname string
		Character firtCharOfString = Character.toUpperCase(contact.getFirstname().charAt(0));
		if(range.get(firtCharOfString) == false) {
			sendFeedback("");
			sendFeedback("---------" + String.valueOf(firtCharOfString));
			sendFeedback("");
			range.replace(firtCharOfString, true);					
		}
	}
	
	/**
	 * display a single contact object to console
	 * @param response
	 */
	private void displayData(Contact response) {
		displayBlankLine();
		sendFeedback("================ Telephone Directory Result ================");
		displayBlankLine();
		displayContactDetails(1, response);
	}
	/**
	 * prompt user to enter search query<br>
	 */
	private String requestQuery() {
		String queryString = null;
		while (queryString == null || queryString.isBlank()) {
			sendFeedback("\nEnter query>");
			sendFeedbackInline("Search by Phone number, Firstname or Lastname> ");
			queryString = scanner.nextLine();			
		}
		return queryString;
	}
	/**
	 * prompt user to enter details for a new contact<br>
	 * <small>prompt for <i>firstname, lastname, phone</i></small>
	 * @return a new contact object
	 */
	private Contact requestNewContactDetails() {
		String firstname = null;
		String lastname = null;
		String phone = null;
		
		displayBlankLine();
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
		
		if(firstname != null && !firstname.isBlank() && lastname != null && !lastname.isBlank() && phone != null && phone.length() == 11) {
			Contact contact = new Contact(firstname, lastname, phone);
			return contact;
		}
		
		return null;
	}
	/**
	 * prompt user for action to either find all matches to query,
	 * find the exact match or quit app
	 * @return boolean
	 */
	private Boolean askToFindAllMatch() {
		char response = 0;
		while (response == 0 || (response != 'Q' && response != '1' && response != '2')) {
			displayBlankLine();
			sendFeedbackInline("Do you want to find all matches? \n(1) Yes find all \n(2) No, find exact match \n(Q) Exit application \n> ");
			response = Character.toUpperCase(scanner.nextLine().charAt(0));
		}
		// if Yes
		if (response == '1' ) {
			return true;
		}
		// if Exit application
		if(response == 'Q') {
			quit();
		}
		// if No
		return false;
	}
	
	/**
	 * A wrapper arround System.out.println. 
	 * Prints string data to the console
	 * @param data
	 */
	void sendFeedback(String data) {
		System.out.println(data);			
	}
	/**
	 * print data inline
	 */
	void sendFeedbackInline(String data) {
		System.out.print(data);			
	}
	/**
	 * print an empty line to std-output
	 */
	private void displayBlankLine() {
		System.out.println();
	}
	/**
	 * <p><i>visual que</i></p>
	 * imitate application startup progress feedback
	 */
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
	/**
	 * <p><i>visual que</i></p>
	 * imitate application exit progress feedback 
	 */	
	void killAppStaticFeedback() {
		final long startTime = System.currentTimeMillis();
		System.out.println();
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
	/**
	 * display total execution time after a task 
	 * @param startTime
	 * @param endTime
	 */
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
