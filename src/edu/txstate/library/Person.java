package edu.txstate.library;

public class Person {
	//private static final long serialVersionUID = 1L;
	private String mFirstName;
	private String mLastName;

	public Person(){
		this.mFirstName = "";
		this.mLastName = "";
	}
	
	public Person(String firstName, String lastName){
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}
	
	public void setFirstName(String firstName){
		this.mFirstName = firstName;
	}

	public void setLastName(String lastName){
		this.mLastName = lastName;		
	}
	
	public String getFirstName(){
		return this.mFirstName;
	}

	public String getLastName() {
		return this.mLastName;
	}
}
