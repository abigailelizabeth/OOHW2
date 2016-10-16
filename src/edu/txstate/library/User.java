package edu.txstate.library;

import java.util.ArrayList;

public abstract class User extends Person{
	private String mUserId;
    private int numBorrowed;
	private ArrayList<Document> borrowedDocuments = new ArrayList<Document>();

	public User(){
		this.mUserId = "";
        this.numBorrowed = 0;
	}

	public User(String firstName, String lastName, String userId){
        super(firstName, lastName);
        this.mUserId = userId;
        this.numBorrowed = 0;
    }
	
	public void setUserId(String userId){
		this.mUserId = userId;
	}


	public int getNumberBorrowed(){
		return this.numBorrowed;
	}


	public String getUserId(){
		return this.mUserId;
	}

	public void registerBorrow(Document document){
		
	}
	public ArrayList<Document> getBorrowedDocuments(){
		return borrowedDocuments;
	}
	public void deregisterBorrow(Document document){
		
	}
	
	public String getFullName(){
		String first = this.getFirstName();
		String last = this.getLastName();
		String full = first + " " + last;
		return full;
	}

}
