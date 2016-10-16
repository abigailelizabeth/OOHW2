package edu.txstate.library;

import jdk.internal.util.xml.impl.Input;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by abiga on 10/15/2016.
 */
public class Console {

    public Console(){}
    public static void welcomeMenu(){
        int i = 0;
        System.out.println("Welcome to Alkek Library System\n");

        // validation of initial menu input

        System.out.println("Select a number to continue\n" +
                "1. Registered User Login\n" +
                "2. Librarian Login\n" +
                "3. Continue as Guest User");

        i = InputValidator.validate(3);

        if(i == 1){
                userLogin();
                displayUserMenu();

        }
        else if(i == 2){
            runLibrarianUI();
        }
        else{
            displayGuestMenu();
        }
    }

    public static void userLogin(){
        String id = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Enter User ID: ");
        id = in.nextLine();
        LibrarySystem.getInstance().setActiveUser(LibrarySystem.getInstance().getUserDirectory().findUserById(id));
        if(LibrarySystem.getInstance().getActiveUser() == null) {
            System.out.println("Sorry no user found, must register first. Continuing as a guest..");
            displayGuestMenu();
        }
    }
    public static void displayGuestMenu(){
        User temp = null;
        LibrarySystem.getInstance().setActiveUser(temp);
        int i = 0;
        System.out.println("Select a number to continue\n" +
                "1. Search Document \n" +
                "2. Exit Session");
        i = InputValidator.validate(2);
        if(i == 1){
            searchDocument();
        }
        else{
            Console.welcomeMenu();
        }
    }
    private static void runLibrarianUI(){
        LibrarianUI.startUI();
    }
    public static void displayUserMenu(){
        int i = 0;
        System.out.println("Hello, " + LibrarySystem.getInstance().getActiveUser().getFirstName() + "\nSelect a number to continue\n" +
                "1. Search Document \n" +
                "2. Checkout Document\n" +
                "3. Return Document\n" +
                "4. View Loans\n" +
                "5. Log out");
        i = InputValidator.validate(5);
        if(i == 1 || i == 2){
            searchDocument();
        }
        else if(i==3){
            if(LibrarySystem.getInstance().getActiveUser().getBorrowedDocuments().isEmpty()){
                System.out.println("No Documents Checked out. ");
                displayUserMenu();
            }
            else {
                System.out.println("CHECKED OUT DOCUMENTS");
                for (int j = 0; j < LibrarySystem.getInstance().getActiveUser().getBorrowedDocuments().size(); j++) {
                    System.out.println((j + 1) + ". " + LibrarySystem.getInstance().getActiveUser().getBorrowedDocuments().get(j).getTitle());
                }
                System.out.println("Select Number of Document You are Returning. \n");
                int indexOfDoc = InputValidator.validate(LibrarySystem.getInstance().getActiveUser().getBorrowedDocuments().size());
                LibrarySystem.getInstance().getActiveUser().deregisterBorrow(LibrarySystem.getInstance().getActiveUser().getBorrowedDocuments().get(indexOfDoc - 1));
                displayUserMenu();
            }
        }
        else if(i==4){
            System.out.println("CHECKED OUT DOCUMENTS");
            for(int j = 0; j < LibrarySystem.getInstance().getActiveUser().getBorrowedDocuments().size(); j++){
                System.out.println((j+1) + ". " + LibrarySystem.getInstance().getActiveUser().getBorrowedDocuments().get(j).getTitle());
            }
            System.out.println("\nPress 1 to exit");
            InputValidator.validate(1);
            displayUserMenu();
        }
        else{
            User a = null;
            LibrarySystem.getInstance().setActiveUser(a);
            Console.welcomeMenu();
        }
}
    private static void searchDocument(){
        Scanner in = new Scanner(System.in);
        String query = "";
        int i = 0;
        System.out.println("Search By: \n" +
                "1. Title\n" +
                "2. Author");
        i = InputValidator.validate(2);
        if(i == 1){
            System.out.println("Enter Title");
            query = in.nextLine();
        }
        else{
            System.out.println("Enter Author's Name:");
            query = in.nextLine();
        }
        LibrarySystem.getInstance().performSearch(i, query);

        displayUserMenu();
    }

}
