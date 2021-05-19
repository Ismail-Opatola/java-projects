package com.opatolaismail.example.teldir;

public class Contact {

	private String firstname;
	private String lastname;
	private String phone;
	
	public Contact(String firstname, String lastname, String phone) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
	}
	public Contact() {
		
	}
	
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getPhone() {
		return phone;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return super.toString();
	}
}
