package edu.txstate.library;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Created by abiga on 10/15/2016.
 */
public class Main {

    public static void main (String[] args){
        LibrarySystem alkek = LibrarySystem.getInstance();

        StudentUser a = new StudentUser("Abigail", "Barron", "A04008715");
        StudentUser b = new StudentUser("Korra", "Paws", "dog01");
        FacultyUser c = new FacultyUser("Jason", "Jalufka", "a0987654321");

        alkek.addUser(a);
        alkek.addUser(b);
        alkek.addUser(c);

        Book one = new Book("alsdfkj", "Sam Sam Outings", "LastNight", "Sam", 3, "Wutang");
        ConferenceProceeding two = new ConferenceProceeding("Dog Park", "Everday", "alsdkfj", "Stop the Leashing", "Last Week", "Korra", 1, "Peanut");

        alkek.addDocument(one);
        alkek.addDocument(two);

        Console clientUI = new Console();

        clientUI.welcomeMenu();



    }


}
