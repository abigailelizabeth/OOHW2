package edu.txstate.library;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Created by abiga on 10/15/2016.
 */
public class Main {

    public static void main (String[] args){
        LibrarySystem alkek = LibrarySystem.getInstance();

        Console clientUI = new Console(alkek);

        clientUI.welcomeMenu();



    }


}
