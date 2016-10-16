package edu.txstate.library;

import java.util.InputMismatchException;
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
                "3. View Transactions\n" +
                "4. Log out");
        i = InputValidator.validate(4);
        if(i ==1){
            addUser();
        }
        else if(i ==2){
            addDocument();
        }
        else if(i == 3){
            //viewTransactions();
        }
        else{
            Console.welcomeMenu();
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
        displayLibrarianMenu();
    }

    private static void addDocument(){
        int i = 0, numCopies, volumeNumber, journalNumber;
        String isbn, title, publishDate, publisher, author;
        Scanner in = new Scanner(System.in);
        System.out.println("ADD DOCUMENT\n" +
                "1. Book\n" +
                "2. Conference Proceeding\n" +
                "3. Journal");
        i = InputValidator.validate(3);

        System.out.println("Enter Title: ");
        title = in.nextLine();

        System.out.println("Enter Publish Date: ");
        publishDate = in.nextLine();
        System.out.println("Enter Publisher: ");
        publisher = in.nextLine();
        System.out.println("Enter number of copies: ");
        try{
           numCopies = in.nextInt();
        }catch(InputMismatchException e){
            System.out.println("Invalid input: Defaulted number of copies to 1");
            numCopies = 1;
        }

        in.nextLine();
        System.out.println("Enter Author Name: ");
        author = in.nextLine();
        if(i ==1 || i== 2){
            System.out.println("Enter ISBN");
            isbn = in.nextLine();

            if(i ==1){
                Book book = new Book(isbn, title, publishDate, publisher, numCopies, author);
                LibrarySystem.getInstance().addDocument(book);
            }
            else{
                System.out.println("Enter Location: ");
                String location = in.nextLine();
                System.out.println("Enter Date: ");
                String date = in.nextLine();
                ConferenceProceeding conferenceProceeding = new ConferenceProceeding(location, date, isbn, title, publishDate, publisher, numCopies, author);
                LibrarySystem.getInstance().addDocument(conferenceProceeding);
            }

        }
        else{
            System.out.println("Enter Journal Number: ");
            try{
                journalNumber = in.nextInt();
            }catch(InputMismatchException e){
                journalNumber = 1;
            }
            System.out.println("Enter Volume Number");
            try{
                volumeNumber = in.nextInt();
            }catch(InputMismatchException e){
                volumeNumber = 1;
            }
            Journal journal = new Journal(title, publishDate, publisher, numCopies, volumeNumber, journalNumber, author);
            LibrarySystem.getInstance().addDocument(journal);
        }
        displayLibrarianMenu();
    }
}
