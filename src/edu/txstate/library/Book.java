package edu.txstate.library;

public class Book extends LongTermDocument {
	private String mIsbn;
	
	public Book(){
		mIsbn = "";
	}
	public Book(String isbn, String title, String publishDate, String publisher, int numCopies, String author){
		super(title, publishDate, publisher, numCopies, author);
		this.setIsbn(isbn);
	}
	
	public void setIsbn(String isbn){
		this.mIsbn = isbn;
	}

	public String getIsbn(){
		return this.mIsbn;
	}
}
