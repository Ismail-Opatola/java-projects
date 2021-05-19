package com.github.ismailopatola.javaproject.telephonedirectory;
import java.util.ArrayList;

interface Database_Interface {
	ArrayList<Object> getAll();
	Object get(int query);
	Object get(String query);
	void create(Object data);
	void update(Object data);
	void delete(int query);
	void delete(String query);
	void connect();
}

public class Database implements Database_Interface {
	private ArrayList<ContactDetails> contactList; // array of contacts
	
	private String pathToDatabase;
	
	public Database(String pathToDatabase) {
		this.pathToDatabase = pathToDatabase;
		this.contactList = new ArrayList<ContactDetails>();
		this.connect();
	}
	
	/**
	 * connect to local database
	 */
	public void connect() {
		if(pathToDatabase != null) {
			// fetch db.json
			// convert json to arrayList<Object>
			// copy to contactList
		}
	}

	/**
	 * Get all contacts from the database
	 */
	@Override
	public ContactDetails[] getAll() {
		return contactList;
	}

	/**
	 *  get a specific contact from the database
	 */
	@Override
	public ContactDetails get(int query) {
		return null;
		
	}

	/**
	 *  get a specific contact from database
	 */
	@Override
	public ContactDetails get(String query) {
		return null;
		
	}

	/**
	 *  add a new contact to the database
	 */
	@Override
	public void create(ContactDetails contactDetails) {
		contactList.add(contactDetails);
	}
	
	/**
	 * update a specific contact in the database
	 */
	@Override
	public void update(ContactDetails contactDetails) {
		
	}

	/**
	 * Delete a specific contact from the database
	 */
	@Override
	public void delete(int query) {
		
	}

	/**
	 * Delete a specific contact from the database
	 */
	@Override
	public void delete(String query) {
		
	}

}
