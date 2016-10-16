package edu.txstate.library;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by abiga on 10/15/2016.
 */
public final class InputValidator {
    private InputValidator(){}

    public static int validate (int num) {
        boolean menuError = true;
        Scanner in = new Scanner(System.in);
        int i = 0;
        do {
            try {
                i = in.nextInt();
                if (getValidation(num, i)) {
                    menuError = false;
                }
                else {
                    System.out.println("**ERROR: Please enter a valid number **");

                }
            } catch (InputMismatchException e) {
                System.out.println("**ERROR: Please enter a valid number**");
                in.next();
            }

        }while (menuError);
        return i;
    }
    private static boolean getValidation(int num, int i){
        boolean validator = false;
        for(int j = num; j > 0; j--){
            if(i == j){
                validator = true;
                continue;
            }

        }
        return validator;
    }

}
