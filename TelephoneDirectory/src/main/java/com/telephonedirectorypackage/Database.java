package com.telephonedirectorypackage;

import java.text.ParseException;
import java.util.ArrayList;
//import java.util.Arrays;

public class Database implements IDatabase {
	
	private ArrayList<Contact> contactList;
	private String pathToDatabase;
	FileHandler fileHandler;
	Helpers helpers;

	/**
	 * Database Constructor
	 * @param pathToDatabase
	 */
	public Database(String pathToDatabase) {
		// set path To db.json file
		this.pathToDatabase = pathToDatabase;
		// instantiate fileHandler 
		this.fileHandler = new FileHandler();
		// instantiate helpers
		this.helpers = new Helpers();
		// load data from storage i.e db.json
		this.contactList = fetchDB();
	}

	/**
	 * get all contacts in database
	 * @return contact list
	 */
	public ArrayList<Contact> getAll() {
		return contactList;
	}

	/**
	 * get a single contact
	 * @param query - string
	 */
	public Contact get(String query) {
		return null;
	}
	
	/**
	 * create and write to database
	 * @param data - contact object
	 */
	public void create(Contact data) {
		try {
			this.contactList.add(data);
			String dataToJSON = helpers.convertListToJSON(contactList);
			fileHandler.writeToJsonFile(this.pathToDatabase, dataToJSON);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * update or patch contact object and write to database
	 * @param data - contact object
	 */
	public void update(Contact data) {}
	
	/**
	 * delete contact object from database
	 * @param query - string
	 */
	public void delete(String query) {}

	/**
	 * find all matches to a query in the database
	 * @param queryString
	 * @return array list of contacts or empty array list 
	 */
	public ArrayList<Contact> findAll(String queryString) {
		// using binary search algorithm
		// ArrayList<Contact> result = Arrays.binarySearch(contactList, queryString);
		// TODO: regex match - contact property contain the queryString i.e "oe" -> deola, joe
		
		ArrayList<Contact> result = new ArrayList<Contact>(); 
		
		for(int i = 0; i < contactList.size(); i++) {
			Contact contact = contactList.get(i);
			if(
				contact.getFirstname().compareToIgnoreCase(queryString) == 0
				|| contact.getLastname().compareToIgnoreCase(queryString) == 0
				|| contact.getPhone().compareToIgnoreCase(queryString) == 0
			) {
				result.add(contact);
			}
		}
		
		return result;
	}
	/**
	 * find exact match to a query in the database
	 * @param queryString
	 * @return contact object or null 
	 */
	public Contact find(String queryString) {
		Contact result = null; 
		
		for(int i = 0; i < contactList.size(); i++) {
			Contact contact = contactList.get(i);
			if(
				contact.getFirstname().compareToIgnoreCase(queryString) == 0
				|| contact.getLastname().compareToIgnoreCase(queryString) == 0
				|| contact.getPhone().compareToIgnoreCase(queryString) == 0
			) {
				result = contact;
			}
		}
		
		return result;	
	}

	/**
	 * fetch db.json file from local storage,
	 * parse and return data
	 * @return array list of contacts 
	 */
	public ArrayList<Contact> fetchDB() {
		try {			
			if(this.pathToDatabase != null || !this.pathToDatabase.isBlank()) {
				return fileHandler.readFromJsonFile(pathToDatabase);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
