
public interface ContactDetails {
	public String firstname;
	 public String lastname;
	 public int phone;
}

public class Contact implements ContactDetails{
	
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
		return firstname;
	}
	
	public String getLastname() {
		return lastname;
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
