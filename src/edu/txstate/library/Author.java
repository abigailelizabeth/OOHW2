package edu.txstate.library;

public class Author {
	private static int counter;
	
	public Author(){
		counter++;
	}
	
	public static int getNumOfInstances(){
		return counter;
	}

}
