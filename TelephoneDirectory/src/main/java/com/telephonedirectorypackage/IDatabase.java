package com.telephonedirectorypackage;

import java.util.ArrayList;

public interface IDatabase {
	ArrayList<Contact> getAll();
	void create(Contact data);
	void update(Contact data);
	void delete(String query);
	ArrayList<Contact> find (String query);
	Contact get(String query);
	ArrayList<Contact> fetchDB();
}
