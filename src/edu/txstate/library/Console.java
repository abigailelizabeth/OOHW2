package edu.txstate.library;

import jdk.internal.util.xml.impl.Input;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by abiga on 10/15/2016.
 */
public class Console {
    private LibrarySystem alkek;
    public Console(LibrarySystem lib){alkek=lib;}
    public void welcomeMenu(){
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
            displayLibrarianMenu();
        }
    }
    public void displayUserMenu(){
        int i = 0;
        System.out.println("Select a number to continue\n" +
                "1. I'm a Student \n" +
                "2. I'm a Faculty Member\n" +
                "3. Register");
        i = InputValidator.validate(3);
        if(i == 1){
            System.out.println("Hi Bobcat Student");
        }
        else if(i == 2){
            System.out.println("Hi Faculty ");
        }
        else{
            System.out.println("Sign up time.");
        }
}

    public void displayLibrarianMenu(){
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

    public void addUser(){
        int i = 0;
        String first, middle, last, id;
        Scanner in = new Scanner(System.in);
        System.out.println("ADD USER\n" +
                "1. Student\n" +
                "2. Faculty");
        InputValidator.validate(2);

        // CREATE STUDENT USER

        System.out.println("Enter First Name: ");
        first = in.nextLine();
        System.out.println("Enter Middle Name: ");
        middle = in.nextLine();
        System.out.println("Enter Last Name: ");
        last = in.nextLine();
        System.out.println("Enter Student ID: ");
        id = in.nextLine();

        if(i == 1){
            StudentUser studentUser = new StudentUser(first, middle, last, id);
            alkek.addUser(studentUser);
        }
        else{ // CREATE FACULTY USER
            FacultyUser facultyUser = new FacultyUser(first, middle, last, id);
            alkek.addUser(facultyUser);
        }


    }
}
