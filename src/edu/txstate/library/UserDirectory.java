package edu.txstate.library;

import java.util.ArrayList;
import java.util.Iterator;

public class UserDirectory<E>{
	//private static final String SAVE_FILENAME = "user_directory.txt";
	private static UserDirectory<User> instance = new UserDirectory<User>();
	private ArrayList<User> users = new ArrayList<User>();
	
	Iterator<User> usr = users.iterator();
	
	private UserDirectory (){
		//ensure class has one instance
	}
	
	public static UserDirectory<User> getInstance(){
		return instance;
	}
	
}
