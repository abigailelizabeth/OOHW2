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
                "1. Continue as User\n" +
                "2. Librarian Login" );

        i = InputValidator.validate(2);

        if(i == 1){
            displayUserMenu();
        }
        else{
            runLibrarianUI();
        }
    }

    private static void runLibrarianUI(){
        LibrarianUI.startUI();
    }
    public static void displayUserMenu(){
        int i = 0;
        System.out.println("Select a number to continue\n" +
                "1. Search Document \n" +
                "2. Checkout Document\n" +
                "3. Return Document\n" +
                "4. View Loans");
        i = InputValidator.validate(4);
        if(i == 1){
            searchDocument();
        }
        else if(i == 2){
           searchDocument();
        }
        else{
            System.out.println("Sign up time.");
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
