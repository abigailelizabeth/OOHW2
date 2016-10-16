package edu.txstate.library;

public abstract class User extends Person{
	private String mUserId;
    private int numBorrowed;
	
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
	
	public void deregisterBorrow(Document document){
		
	}
	
	public String getFullName(){
		String first = this.getFirstName();
		String last = this.getLastName();
		String full = first + " " + last;
		return full;
	}

}
