package com.opatolaismail.example.teldir;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Helpers {
	
	public Helpers() {}
	
	public String convertListToJSON(ArrayList<?> data) {
		Gson prettyGson = new GsonBuilder()
								.serializeNulls()
								.setPrettyPrinting()
								.create();
		String prettyJson = prettyGson.toJson(data);
		return prettyJson;
	}
	
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

}
