package com.opatolaismail.example.teldir;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Contact c1 = new Contact("Ismail", "Opatola", "08117464199");
		Contact c2 = new Contact("Fadihlat", "Opatola", "09000000001");
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		contacts.add(c1);
		contacts.add(c2);
		
		System.out.println(contacts);
		
		FileHandler fileHandler = new FileHandler();
		Helpers helpers = new Helpers();
		
		// save data to file
		fileHandler.writeToJsonFile("db.json", helpers.convertListToJSON(contacts));
		System.out.println("Saved to db");
		
		try {
			// read data from file
			ArrayList<Contact> data = fileHandler.readFromJsonFile("db.json");
			System.out.println(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
