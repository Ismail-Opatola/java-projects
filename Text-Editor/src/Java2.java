import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
 
class UserDefinedException extends Exception {
    String msg;
    UserDefinedException(String msg) {
        this.msg=msg;
    }
    public String toString() {
        return msg;
    }
}
// Class name should be "Source",
// otherwise solution won't be accepted
public class Java2 {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        // Declare the variable
        int a;
        
        // Read the variable from STDIN
        a = in.nextInt();
        
        // Output the variable to STDOUT
        try {
            if(a <= 0) {
                throw new UserDefinedException("Invalid Amount");
            }
            System.out.println("Amount Deposited");
        } catch(UserDefinedException e) {
            System.out.println(e);
        }
   }
}

public class Java4 {
    
    public static void main(String[] args) {
        System.out.println("Please enter an amount");
        Scanner in = new Scanner(System.in);
        //Declare the variable
        int a;
        
        //Read the variable from std
        a = in.nextInt();
        
        try {
            System.out.println(UserDefinedException(a));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    private static String UserDefinedException(int amount) throws Exception {
          String message;
          if(amount <= 0) {
              throw new Exception("Invalid Amount");
          } else {
              message = "Amount Deposited";
          }
          return message;
    }

}

public class Tempc {

	public static void main(String[] args) {
		Scanner scanner =  new Scanner(System.in);
		int a,b,c,d;
		System.out.println("");
		a = scanner.nextInt();
		b = scanner.nextInt();
		c = scanner.nextInt();
		d = (b*b) - 4 * a * c;
		if(d > 0.0) {
			double r1 = ((-b + Math.sqrt(d))/(2*a));
			double r2 = ((-b - Math.sqrt(d))/(2*a));
			System.out.println("Roots are real numbers");
			System.out.printf("Roots of quadratic equation are: %.3f %.3f",r1,r2);
		} else if (d == 0.0) {
			double r1 = (-b / (2*a));
			System.out.println("Both roots are equal");
			System.out.printf("Roots of quadratic equation is: %.3f",r1);
		} else {
			System.out.println("Roots are complex numbers");
		}
		scanner.close();
	}

}
