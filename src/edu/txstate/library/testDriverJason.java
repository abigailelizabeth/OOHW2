package edu.txstate.library;
import java.util.Scanner;

public class testDriverJason {

	public static void main(String[] args) {
		
		System.out.println("TESTING");
		LibrarySystem alkek = LibrarySystem.getInstance();
		
		Scanner input = new Scanner(System.in);

		StudentUser user1 = new StudentUser();
		alkek.addUser(user1);
	}

}
