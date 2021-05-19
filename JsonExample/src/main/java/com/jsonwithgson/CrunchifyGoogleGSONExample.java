package com.jsonwithgson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
 
import org.json.JSONArray;
import org.json.JSONObject;
 
import com.google.gson.Gson;
 
/**
 * @author Crunchify.com 
 * Gson() -> fromJson() to deserializes the specified Json into an object of the specified class
 */
 
public class CrunchifyGoogleGSONExample {
 
	public static void main(String[] args) {
		JSONArray array = readFileContent();
		convertJSONArraytoArrayList(array);
	}
 
	private static void convertJSONArraytoArrayList(JSONArray array) {
 
		// Use method fromJson() to deserializes the specified Json into an object
		// of the specified class
		final ArrayList<?> jsonArray = new Gson().fromJson(array.toString(), ArrayList.class);
		log("\nArrayList: " + jsonArray);
 
	}
 
	private static JSONArray readFileContent() {
		JSONArray crunchifyArray = new JSONArray();
		String lineFromFile;
 
		try (BufferedReader bufferReader = new BufferedReader(new FileReader("crunchify-gson.txt"))) {
 
			while ((lineFromFile = bufferReader.readLine()) != null) {
				if (lineFromFile != null && !lineFromFile.isEmpty()) {
					JSONObject crunchifyObject = new JSONObject();
					log("Line: ==>" + lineFromFile);
 
					// escape any blank space between tokens
					String[] split = lineFromFile.split("\\s+");
					crunchifyObject.put("companyName", split[0]);
					crunchifyObject.put("address", split[1]);
					crunchifyObject.put("description", split[2]);
					crunchifyArray.put(crunchifyObject);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\nJSONArray: " + crunchifyArray.toString());
		return crunchifyArray;
 
	}
 
	private static void log(Object string) {
		System.out.println(string);
	}
}

/***
Line: ==>Crunchify.com  NewYork        Java&Blogging
Line: ==>Google.com     MountainView        SearchEngine
Line: ==>Facebook.com      SanJose          SocialMedia
Line: ==>Twitter.com          SanFrancisco         TweetTweet
 
JSONArray: [{"address":"NewYork","companyName":"Crunchify.com","description":"Java&Blogging"},{"address":"MountainView","companyName":"Google.com","description":"SearchEngine"},{"address":"SanJose","companyName":"Facebook.com","description":"SocialMedia"},{"address":"SanFrancisco","companyName":"Twitter.com","description":"TweetTweet"}]
 
ArrayList: [{address=NewYork, companyName=Crunchify.com, description=Java&Blogging}, {address=MountainView, companyName=Google.com, description=SearchEngine}, {address=SanJose, companyName=Facebook.com, description=SocialMedia}, {address=SanFrancisco, companyName=Twitter.com, description=TweetTweet}]
*/