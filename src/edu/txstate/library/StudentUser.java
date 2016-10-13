package edu.txstate.library;

public class StudentUser extends User {
    private static final int STUDENT_BORROW_LIMIT = 6;
    private int numberBorrowed;

    public int getStudentBorrowLimit() {
        return this.STUDENT_BORROW_LIMIT;
    }
}
