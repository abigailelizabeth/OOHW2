package edu.txstate.library;
import java.util.Scanner;

public class testDriverJason {

	public static void main(String[] args) {
		
		System.out.println("TESTING");
		LibrarySystem alkek = LibrarySystem.getInstance();
		
		Scanner input = new Scanner(System.in);
		System.out.println("---Calling loadData from LibrarySystem---");
        System.out.println("Successfully Loaded Data");
        User userboi = new StudentUser("Bob", "Sammy", "98765");
        alkek.addUser(userboi);
        System.out.println("Saving Data to users.txt");
        System.out.println("Saved Data to users.txt, check the file to see if output is correct.");

	}

}
