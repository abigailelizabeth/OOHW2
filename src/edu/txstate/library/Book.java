package edu.txstate.library;

public class Book extends LongTermDocument {
	private long serialVersionUID;
	private String mIsbn;
	
	public Book(){
		serialVersionUID = 0;
		mIsbn = "";
	}
	public Book(long serial, String isbn, String title, String publishDate, String publisher, int numCopies, String author){
		super(title, publishDate, publisher, numCopies, author);
		this.setIsbn(isbn);
		this.setSerialVersionUID(serial);
	}
	
	public void setIsbn(String isbn){
		this.mIsbn = isbn;
	}
	public void setSerialVersionUID(long serial){
		this.serialVersionUID = serial;
	}
	
	public String getIsbn(){
		return this.mIsbn;
	}
}
