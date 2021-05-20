package com.telephonedirectorypackage;

import java.util.UUID;

public class Contact {

	private UUID uid;
	private String firstname;
	private String lastname;
	private String phone;
	
	public Contact(String firstname, String lastname, String phone) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		// generate unique identifier
		this.uid = UUID.randomUUID();
		
	}
	
	public Contact() {
		// generate unique identifie
		this.uid = UUID.randomUUID();		
	}
	public UUID getUid() {
		return uid;
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
