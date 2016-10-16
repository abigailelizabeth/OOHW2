package edu.txstate.library;

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;

public class StudentUser extends User {
    private static final int STUDENT_BORROW_LIMIT = 6;
    private int numberBorrowed;

    public StudentUser(String firstName, String lastName, String userId){
        super(firstName, lastName, userId);
        this.numberBorrowed = 0;
    }
    public static int getStudentBorrowLimit(){
        return STUDENT_BORROW_LIMIT;
    }

    @Override
    public void registerBorrow(Document document){
        if(document.getNumberOfCopies() > 0){
            if(this.numberBorrowed < getStudentBorrowLimit()){
                this.numberBorrowed++;
                document.deccrementNumberOfCopies();
                Date date = new Date();
                SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yy");
                LoanTransaction loan = new LoanTransaction(LoanTransaction.getTransactionNum(), this, document, ft.format(date));
                LoanTransactionDirectory.getInstance().addTransaction(loan);
                LibrarySystem.getInstance().saveData();
            }
            else{
                System.out.println(this.getFirstName() + ", you have already reached your check out limit.");
            }
        }
        else{
            System.out.println("Sorry " + this.getFullName() + ", this book is currently not available.");
        }
    }

    @Override
    public void deregisterBorrow(Document document){
        this.numberBorrowed--;
        document.incrementNumberOfCopies();
        // find the transaction maybe create a function to find the transaction by the document
        // have it return the transaction and we acn remove it
        //
    }

    @Override
    public String toString(){
        return getFirstName() + "\t" + getLastName() + "\t" + getUserId() + "\tstudent\n";
    }
}
