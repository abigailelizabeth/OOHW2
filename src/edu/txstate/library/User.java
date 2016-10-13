package edu.txstate.library;

public abstract class User extends Person{
	private String mUserId;
	
	public User(){
		this.mUserId = "";
	}
	
	public void setUserId(String userId){
		this.mUserId = userId;
	}
	
	public int getNumberBorrowed(){
		return 0;
	}
	
	public void registerBorrow(){
		
	}
	
	public void deregisterBorrow(){
		
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
