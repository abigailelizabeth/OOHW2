package edu.txstate.library;

public abstract class User extends Person{
	private String mUserId;
    private int numBorrowed;
	
	public User(){
		this.mUserId = "";
        this.numBorrowed = 0;
	}

	public User(String firstName, String middleName, String lastName, String userId){
        super(firstName, middleName, lastName);
        this.mUserId = userId;
        this.numBorrowed = 0;
    }
	
	public void setUserId(String userId){
		this.mUserId = userId;
	}
	
	public int getNumberBorrowed(){
		return this.numBorrowed;
	}
	
	public void registerBorrow(Document document){
		
	}
	
	public void deregisterBorrow(Document document){
		
	}
	
	public String getUserId(){
		return this.mUserId;
	}
	
	public String getFullName(){
		String first = this.getFirstName();
		String middle = this.getMiddleName();
		String last = this.getLastName();
		String full = first + " " + middle + " " + last;
		
		return full;
	}

}
