package edu.txstate.library;

public class Person {
	//private static final long serialVersionUID = 1L;
	private String mFirstName;
	private String mMiddleName;
	private String mLastName;

	public Person(){
		this.mFirstName = "";
		this.mMiddleName = "";
		this.mLastName = "";
	}
	
	public Person(String firstName, String middleName, String lastName){
		this.setFirstName(firstName);
		this.setMiddleName(middleName);
		this.setLastName(lastName);
	}
	
	public void setFirstName(String firstName){
		this.mFirstName = firstName;
	}
	
	public void setMiddleName(String middleName){
		this.mMiddleName = middleName;
	}
	
	public void setLastName(String lastName){
		this.mLastName = lastName;		
	}
	
	public String getFirstName(){
		return this.mFirstName;
	}
	
	public String getMiddleName(){
		return this.mMiddleName;
	}
	
	public String getLastName() {
		return this.mLastName;
	}
}
