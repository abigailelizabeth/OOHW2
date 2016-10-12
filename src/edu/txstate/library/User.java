package edu.txstate.library;

public abstract class User {
	private String mUserId;
	
	public User(){
		
	}
	
	public void setUserId(String userId){
		this.mUserId = userId;
	}
	
	public String getUserId(){
		return this.mUserId;
	}

}
