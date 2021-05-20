package com.telephonedirectorypackage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

public class Database implements IDatabase {
	
	private ArrayList<Contact> contactList;
	private String pathToDatabase;
	FileHandler fileHandler;
	Helpers helpers;

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

	public ArrayList<Contact> getAll() {
		return contactList;
	}

	public Contact get(String query) {
		return null;
	}
	
	public void create(Contact data) {
		try {
			this.contactList.add(data);
			String dataToJSON = helpers.convertListToJSON(contactList);
			fileHandler.writeToJsonFile(this.pathToDatabase, dataToJSON);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void update(Contact data) {}

	public void delete(String query) {}

	public ArrayList<Contact> find(String queryString) {
		// using binary search algorithm
		// ArrayList<Contact> result = Arrays.binarySearch(contactList, queryString);
		
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
