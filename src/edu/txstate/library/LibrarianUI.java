package edu.txstate.library;

import java.util.Scanner;

/**
 * Created by abiga on 10/15/2016.
 */
public class LibrarianUI {
    LibrarianUI(){}

    public static void startUI(){
        displayLibrarianMenu();
    }
    private static void displayLibrarianMenu(){
        int i = 0;
        System.out.println("LIBRARIAN ADMIN MENU\nSelect a number to continue\n" +
                "1. Add a User\n" +
                "2. Add a Document\n" +
                "3. View Transactions");
        i = InputValidator.validate(3);
        if(i ==1){
            addUser();
        }
        else if(i ==2){
            //addDocument();
        }
        else{
            //viewTransactions();
        }
    }


    private static void addUser(){
        int i = 0;
        String first, last, id;
        Scanner in = new Scanner(System.in);
        System.out.println("ADD USER\n" +
                "1. Student\n" +
                "2. Faculty");
        InputValidator.validate(2);

        // CREATE STUDENT USER

        System.out.println("Enter First Name: ");
        first = in.nextLine();

        System.out.println("Enter Last Name: ");
        last = in.nextLine();
        System.out.println("Enter Student ID: ");
        id = in.nextLine();

        if(i == 1){
            StudentUser studentUser = new StudentUser(first, last, id);
            LibrarySystem.getInstance().addUser(studentUser);
        }
        else{ // CREATE FACULTY USER
            FacultyUser facultyUser = new FacultyUser(first, last, id);
            LibrarySystem.getInstance().addUser(facultyUser);
        }
        LibrarySystem.getInstance().displayUsers();

    }

}
