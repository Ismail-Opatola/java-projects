package com.github.ismailopatola.telephonedirectory;

import org.json.simple.JSONObject;

/**
 * Utilities - contains reusable methods
 * to help format data
 */
public class Helpers {
	
	
	/**
	 * Custom Iterator with index
	 * @param <T>
	 * @param source
	 * @param consumer
	 */
	static <T> void forEachWithCounter(Iterable<T> source, BiConsumer<Integer, T> consumer) {
		int i = 0;
		for(T item: source) {
			consumer.accept(i, item);
			i++;
		}
	}
	
	/**
	 * compare two contacts by firtsname
	 * @param s1
	 * @param s2
	 * @return
	 */
	public int compare(JSONObject s1, JSONObject s2) {
		String s1Firstname = (String) s1.get("firstname");
		String s2Firstname = (String) s2.get("firstname");			
		return s1Firstname.compareTo(s2Firstname);
	}
	
	/**
	 * parse and print contact object to console
	 * @param i
	 * @param contact
	 */
    public static void parseContactObject(int i, JSONObject contact) {
    	String firstname = (String) contact.get("firstname");    
    	String lastname = (String) contact.get("lastname");    
        int phone = (int) contact.get("phone");    

    	System.out.println(
				"(" + i + 1 + ")" 
				+ " " 
				+ "Firstname: " 
				+ firstname 
				+ " " 
				+ "Lastname: " 
				+ lastname 
				+ " " + "Phone: " 
				+ String.valueOf(phone));
    }
    
    public static JSONObject objectTJSONObject(Object object) {
    	JSONObject json = (JSONObject) object;
    	return json;
    }
    
//    public static JSONArray objectTJSONArray(Object object) {
//    	Object json = null;
//    	JSONArray jsonArray = null;
//    	try {
//			json = new JSONTokener(object.toString()).nextValue();
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//    	
//    	if(json instanceof JSONArray) {
//    		jsonArray = (JSONArray) json;
//    	}
//    	return jsonArray;
//	}

}
