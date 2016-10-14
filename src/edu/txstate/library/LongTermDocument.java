package edu.txstate.library;

public abstract class LongTermDocument extends Document {
	private static final int STUDENT_LOAN_TIME = 6;
	private static final int FACULTY_LOAN_TIME = 12;

	public LongTermDocument(){}
	public LongTermDocument(String title, String publishDate, String publisher, int num){
		super(title, publishDate, publisher, num);

	}
	public static int getStudentTime(){
		return STUDENT_LOAN_TIME;
	}
	public static int getFacultyTime(){
		return FACULTY_LOAN_TIME;
	}



}
