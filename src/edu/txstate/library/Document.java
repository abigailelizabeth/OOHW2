package edu.txstate.library;

public abstract class Document {
	private String mAuthor;
	private String mTitle;
	private String mPublishDate;
	private String mPublisher;
	private int mNumberOfCopies;
	private static int counter = 0;
	
	// Constructor
	public Document(){
		mTitle = "";
		mPublishDate = "";
		mPublisher = "";
		mNumberOfCopies = 0;
		mAuthor = "";
		counter++;
	}
	public Document(String title, String publishDate, String publisher, int num, String author){
		this.setTitle(title);
		this.setPublishDate(publishDate);
		this.setPublisher(publisher);
		this.setNumberOfCopies(num);
		this.setAuthor(author);
	}
	
	// All the Setters
	public void setTitle(String title){
		this.mTitle = title;
	}
	public void setPublishDate(String publishDate){
		this.mPublishDate = publishDate;
	}
	public void setPublisher(String publisher){
		this.mPublisher = publisher;
	}
	public void setNumberOfCopies(int num){
		this.mNumberOfCopies = num;
	}
	public void setAuthor(String name){
		this.mAuthor = name;
	}
	
	//All the Getters
	public String getTitle(){
		return this.mTitle;
	}
	public String getAuthor(){
		return this.mAuthor;
	}
	public String getPublishDate(){
		return this.mPublishDate;
	}
	public String getPublisher(){
		return this.mPublisher;
	}
	public int getNumberOfCopies(){
		return this.mNumberOfCopies;
	}
	public int getNumberOfAuthors(){
		return Author.getNumOfInstances();
	}
	public static int getNumOfInstances(){
		return counter;
	}
	
	// update mNumberOfCopies
	public void incrementNumberOfCopies(){
		this.mNumberOfCopies = this.mNumberOfCopies + 1;
	}
	public void deccrementNumberOfCopies(){
		this.mNumberOfCopies = this.mNumberOfCopies - 1;
	}
	

}
