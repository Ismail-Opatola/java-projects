import java.util.Scanner;

public class TelephoneDirectory {
	private Scanner scanner;

	/**
	 * constructor
	 */
	TelephoneDirectory() {
		scanner = new Scanner(System.in);
		// file
		
		System.out.println("[########] Launching Telephone Directory");
		System.out.println("[########] Done!");
		
		askQuestion();
	}

	private void askQuestion() {

		while (true) {

			System.out.println("\nWhat do you want to do? Enter a Key...");
			System.out.println("(H)elp \n(N)ew Contact \n(L)ist \n(F)ind \n(Q)uit");
			
			char response = Character.toUpperCase(scanner.nextLine().charAt(0));
			
			switch (response) {
			case 'H':
				help();
				break;
			case 'N':
				newContact();
				break;
			case 'L':
				list();
				break;
			case 'D':
				find();
				break;
			case 'Q':
				quit();
				break;

			default:
				System.out.println("Not a valid answer");
				break;
			}
			
		}

	}

	/**
	 * Exit application
	 */
	private void quit() {
		System.out.println("Thank you, have a nice day!");
		System.exit(0);
	}

	/**
	 * find a contact
	 */
	private void find() {
				
	}

	/**
	 * list all contacts
	 */
	private void list() {
		
	}

	/**
	 * create a new contact
	 */
	private void newContact() {
		
	}

	/**
	 * Displays help about Telephone Directory cmdlets
	 */
	private void help() {
		
		System.out.println("\nTOPIC\r\n"
				+ "    Telephone Directory Help System\r\n"
				+ "\r\n"
				+ "DESCRIPTION\r\n"
				+ "    Displays help about Telephone Directory cmdlets and concepts.");
		
		System.out.println("-- More  --");
	}
}
