package com.telephonedirectorypackage;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Helpers {

	public Helpers() {}
	
	/**
	 * convert arraylist of contact to json
	 * @param data - contact list
	 * @return json - string
	 */
	public String convertListToJSON(ArrayList<Contact> data) {
		Gson prettyGson = new GsonBuilder()
								.serializeNulls()
								.setPrettyPrinting()
								.create();
		String prettyJson = prettyGson.toJson(data);
		return prettyJson;
	}
	/**
	 * convert contact object to json
	 * @param data - contact object
	 * @return json - string
	 */
	public String convertObjectToJSON(Contact data) {
		// Use this builder to construct a Gson instance when you need to set configuration options other than the default.
		GsonBuilder gsonBuilder = new GsonBuilder();
		
		// This is the main class for using Gson. 
		// Gson is typically used by first constructing a Gson instance and then invoking toJson(Object) or fromJson(String, Class) methods on it. 
		// Gson instances are Thread-safe so you can reuse them freely across multiple threads.
		Gson gson = gsonBuilder
					.serializeNulls()
					.create();
	
		String objectJson = gson.toJson(data);
		
		return objectJson;
	}
	
	/**
	 * compare two contacts by firtsname
	 * @param s1
	 * @param s2
	 * @return
	 */
	public int compare(Contact s1, Contact s2) {
		String s1Firstname = (String) s1.getFirstname();
		String s2Firstname = (String) s2.getFirstname();			
		return s1Firstname.compareTo(s2Firstname);
	}
	
	
	/**
	 * Custom Iterator with index
	 * @param <T>
	 * @param source
	 * @param consumer
	 */
	<T> void forEachWithCounter(Iterable<T> source, BiConsumer<Integer, T> consumer) {
		int i = 0;
		for(T item: source) {
			consumer.accept(i, item);
			i++;
		}
	}
	
}
