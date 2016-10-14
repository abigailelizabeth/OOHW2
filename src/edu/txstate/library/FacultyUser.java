package edu.txstate.library;

/**
 * Created by Jason on 10/13/2016.
 */
public class FacultyUser extends User {
    private static final int FACULTY_BORROW_LIMIT = 12;
    private int numberBorrowed;

    public FacultyUser(String firstName, String middleName, String lastName, String userId){
        super(firstName, middleName, lastName, userId);
        this.numberBorrowed = 0;
    }

    public static int getFacultyBorrowLimit(){
        return FACULTY_BORROW_LIMIT;
    }

    @Override
    public void registerBorrow(Document document){
        if(document.getNumberOfCopies() > 0){
            if(this.numberBorrowed < getFacultyBorrowLimit()){
                this.numberBorrowed++;
                document.deccrementNumberOfCopies();
            }
            else{
                System.out.println("You have already reached your check out limit.");
            }
        }
        else{
            System.out.println("This book is currently not available.");
        }
    }

    @Override
    public void deregisterBorrow(Document document){
        this.numberBorrowed--;
        document.incrementNumberOfCopies();
    }
}