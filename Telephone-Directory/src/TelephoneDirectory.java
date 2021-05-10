import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TelephoneDirectory {
	private Scanner scanner;
	private Contact[] contactList; // array of contacts
	
	/**
	 * constructor
	 */
	TelephoneDirectory() {
		scanner = new Scanner(System.in);
		// file
		
		System.out.println("[########] Execute - Launch Telephone Directory App");
		System.out.println("[########] Done!");
		
		askQuestion();
	}

	private void askQuestion() {

		while (true) {

			System.out.println("\nWhat do you want to do? Enter a Key...");
			System.out.print("(H)elp \n(N)ew Contact \n(L)ist \n(F)ind \n(Q)uit \n> ");
			
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
		System.out.println("[########] Execute - Stop Application");
		System.out.println("[########] Done!");
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
		/**
		 * stream help.txt to console
		 */
		try {
			FileReader reader = new FileReader("lib/help.txt");
			int data = reader.read(); // stream returns -1 if empty
			while(data != -1) {
				System.out.print((char)data);
				data = reader.read();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 	
	}
}
