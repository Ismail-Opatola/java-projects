package com.opatolaismail.example.teldir;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.lang.reflect.Type;

//import org.json.JSONArray;
//import org.json.JSONObject;
 
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class FileHandler {
	
	public FileHandler() {}
	
	public void writeToJsonFile(String filePath, String jsonData) {		
		//Write JSON file
		try (FileWriter file = new FileWriter(filePath)) {
			// we can write jsonData to the file
			file.write(jsonData); 
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		Resource specification not allowed here for source level below 1.7
	}
	
	public ArrayList<Contact> readFromJsonFile(String filePath) throws ParseException {
		try (FileReader reader = new FileReader(filePath)) {
            // Deserialize JSON data
			Type contactsType = new TypeToken<ArrayList<Contact>>(){}.getType(); 
			final ArrayList<Contact> data = new Gson().fromJson(reader, contactsType);			
			return data;
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
	}
	
}





/**
 * 
 * 
	public ArrayList<?> readFromJsonFile(String filePath) throws ParseException {
		try (FileReader reader = new FileReader(filePath)) {
            // Deserialize JSON data
			final ArrayList<?> data = new Gson().fromJson(reader, ArrayList.class);			
			return data;
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
	}
*/