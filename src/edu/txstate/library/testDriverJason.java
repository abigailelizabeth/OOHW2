package edu.txstate.library;
import java.util.Scanner;

public class testDriverJason {

	public static void main(String[] args) {
		
		System.out.println("TESTING");
		LibrarySystem alkek = LibrarySystem.getInstance();
		
		Scanner input = new Scanner(System.in);

		//StudentUser user1 = new StudentUser();
		//alkek.addUser(user1);
		System.out.println("---Calling loadData from LibrarySystem---");
		alkek.loadData();
        System.out.println("Successfully Loaded Data");
        System.out.println("Adding student user Jerome Maxwell with id 8");
        User userboi = new StudentUser("Bob", "Sammy", "98765");
        alkek.addUser(userboi);
        System.out.println("Added Jerome");
        System.out.println("Saving Data to users.txt");
        alkek.saveData();
        System.out.println("Saved Data to users.txt, check the file to see if output is correct.");

	}

}
