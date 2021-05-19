package com.github.ismailopatola.telephonedirectory;

//import java.util.Map;

import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
import org.json.simple.JSONObject;

interface DatabaseInterface {
	JSONArray getAll();
	/**
	 *  add a new contact to the database
	 */
	void create(JSONObject data);
	Contact get(int query);
	Contact get(String query);
//	void create(Map<String, String> data);
	void update(Contact data);
	void delete(int query);
	void delete(String query);
	JSONArray fetchDB();
}

public class Database implements DatabaseInterface {
	private JSONArray contactList = new JSONArray();
; // array of contacts
	
	private String pathToDatabase;
	
	FileHandler fileHandler;
	
	public Database(String pathToDatabase) {
		// set path To db.json file
		this.pathToDatabase = pathToDatabase;
		// instanstiate fileHandler class
		this.fileHandler = new FileHandler();
		// load data from storage i.e db.json
		this.contactList = fetchDB();
	}
	
	/**
	 * connect to local database
	 * @return - JSONArray
	 */
	public JSONArray fetchDB() {
		if(this.pathToDatabase == null || this.pathToDatabase.isBlank()) {
			return contactList;
		}
		return fileHandler.ReadJSON(pathToDatabase);
	}

	/**
	 * Get all contacts from the database
	 */
	@Override
	public JSONArray getAll() {
		return contactList;
	}

	/**
	 *  get a specific contact from the database
	 */
	@Override
	public Contact get(int query) {
		return null;
		
	}

	/**
	 *  get a specific contact from database
	 */
	@Override
	public Contact get(String query) {
		return null;
		
	}

	/**
	 *  add a new contact to the database
	 */
	@Override
	public void create(JSONObject data) {
//		JSONObject newData = Helpers.objectToJSONObject(data);
		
		// add to contactList
		this.contactList.add(Helpers.objectToJSONObject(data));
		this.contactList.add(data);
		// save to storage
		fileHandler.WriteJSON(pathToDatabase, contactList);
	}
	
	/**
	 * update a specific contact in the database
	 */
	@Override
	public void update(Contact data) {
		
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

