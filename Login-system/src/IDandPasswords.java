import java.util.HashMap;

public class IDandPasswords {
	
	// HashMap good for storing key,value pairs
	HashMap<String, String> loginInfo = new HashMap<String, String>();
	
	IDandPasswords() {
		// DB
		loginInfo.put("Bro", "pizza");
		loginInfo.put("Brometheus", "PASSWORD");
		loginInfo.put("BroCode", "1234pass");
	}
	
	protected HashMap<String, String> getLoginInfo() {
		return loginInfo;
	}
	
	
}
