import java.util.Scanner;

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
