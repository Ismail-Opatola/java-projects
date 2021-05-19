package com.jsonwithgson;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CrunchifyArrayListToJsonObject {
	public CrunchifyArrayListToJsonObject() {
	
		ArrayList<String> crunchify = new ArrayList<String>();
		crunchify.add("Google");
		crunchify.add("Facebook");
		crunchify.add("Crunchify");
		crunchify.add("Twitter");
		crunchify.add("Snapchat");
		crunchify.add("Microsoft");
		log("Raw ArrayList ===> " + crunchify);
		
		// Use this builder to construct a Gson instance when you need to set configuration options other than the default.
		GsonBuilder gsonBuilder = new GsonBuilder();
		
		// This is the main class for using Gson. Gson is typically used by first constructing a Gson instance and then invoking toJson(Object) or fromJson(String, Class) methods on it. 
		// Gson instances are Thread-safe so you can reuse them freely across multiple threads.
		Gson gson = gsonBuilder.create();
	
		String JSONObject = gson.toJson(crunchify);
		log("\nConverted JSONObject ==> " + JSONObject);
		
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String prettyJson = prettyGson.toJson(crunchify);
		
		log("\nPretty JSONObject ==> " + prettyJson);
	}
	
	private static void log(Object print) {
		System.out.println(print);
	}
}
