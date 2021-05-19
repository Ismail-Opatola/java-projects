package com.github.ismailopatola.telephonedirectory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
 
import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public class FileHandler {
	
	JSONArray ReadJSON(String filePath) {
		 //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader(filePath))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray contactList = (JSONArray) obj;
            
            return contactList;
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
	}
	
	void WriteJSON(String filePath, JSONArray contactList) {
        //Write JSON file
        try (FileWriter file = new FileWriter(filePath)) {
            // we can write any JSONArray or JSONObject instance to the file
            file.write(contactList.toJSONString()); 
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
