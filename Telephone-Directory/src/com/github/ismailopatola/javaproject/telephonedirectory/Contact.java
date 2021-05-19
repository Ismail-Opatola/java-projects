package com.github.ismailopatola.javaproject.telephonedirectory;

public class Contact implements ContactInterface{
	
	String firstname;
	String lastname;
	int phone;
	
	/**
	 * Contact Constructor
	 * @param firstname
	 * @param lastname
	 * @param phone
	 */
	
	Contact(String firstname, String lastname, int phone) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
	}
	
	/**
	 * Getters
	 * -------
	 */
	
	public String getFirstname() {
		return this.firstname;
	}
	
	public String getLastname() {
		return this.lastname;
	}
	
	public int getPhone() {
		return this.phone;
	}
	
	/**
	 * Setters
	 * -------
	 */
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public void setPhone(int phone) {
		this.phone = phone;
	}
}
