
public class Main {

	public static void main(String[] args) {
		/**
		 * A simple Login system,
		 * saves Id and Password to an HashMap
		 * No Database
		 */
		
		IDandPasswords iDandPasswords = new IDandPasswords();
		
		LoginPage loginPage = new LoginPage(iDandPasswords.getLoginInfo());

	}

}
