package com.github.ismailopatola.telephonedirectory;

import java.util.HashMap;

public class Contact extends HashMap<String, String> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	String firstname;
//	String lastname;
//	String phone;
	
	/**
	 * Contact Constructor
	 * @param firstname
	 * @param lastname
	 * @param phone
	 */
	
	Contact(String firstname, String lastname, String phone) {
//		this.firstname = firstname;
//		this.lastname = lastname;
//		this.phone = phone;
		this.put("firstname", firstname);
		this.put("lastname", lastname);
		this.put("phone", phone);
	}
//	
//	/**
//	 * Getters
//	 * -------
//	 */
//	
//	public String getFirstname() {
//		return this.firstname;
//	}
//	
//	public String getLastname() {
//		return this.lastname;
//	}
//	
//	public String getPhone() {
//		return this.phone;
//	}
//	
//	/**
//	 * Setters
//	 * -------
//	 */
//	
//	public void setFirstname(String firstname) {
//		this.firstname = firstname;
//	}
//	
//	public void setLastname(String lastname) {
//		this.lastname = lastname;
//	}
//	
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
}
