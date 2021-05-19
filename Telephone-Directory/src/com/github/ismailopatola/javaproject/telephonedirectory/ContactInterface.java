package com.github.ismailopatola.javaproject.telephonedirectory;

public interface ContactInterface {
	String getFirstname();
	String getLastname();
	int getPhone();
	void setFirstname(String firstname);
	void setLastname(String lastname);
	void setPhone(int phone);
}