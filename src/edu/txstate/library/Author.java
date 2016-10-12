package edu.txstate.library;

public class Author {
	private static int counter = 0;
	
	public Author(){
		counter++;
	}
	
	public static int getNumOfInstances(){
		return counter;
	}

}
