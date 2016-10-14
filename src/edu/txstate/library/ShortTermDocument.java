package edu.txstate.library;

public class ShortTermDocument extends Document {
    private static final int STUDENT_LOAN_TIME = 3;
    private static final int FACULTY_LOAN_TIME = 3;

    public ShortTermDocument(String title, String publishDate, String publisher, int num, String author){
        super(title, publishDate, publisher, num, author);
    }

    public ShortTermDocument(){
        //Does nothing
    }

    public static int getStudentLoanTime(){
        return STUDENT_LOAN_TIME;
    }

    public static int getFacultyLoanTime(){
        return FACULTY_LOAN_TIME;
    }
}
