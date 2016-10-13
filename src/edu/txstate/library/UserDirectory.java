package edu.txstate.library;

import java.util.ArrayList;
import java.util.Iterator;

public class UserDirectory{
	//private static final String SAVE_FILENAME = "user_directory.txt";
	private static UserDirectory instance = new UserDirectory();
	private static ArrayList<User> users = new ArrayList<User>();
	
	Iterator<User> usr = users.iterator();
	
	private UserDirectory (){
		System.out.println("I am a UserDirectory Instance.");
		//ensure class has one instance
	}
	
	public static UserDirectory getInstance(){
		return instance;
	}
	
	public static void addUser(User e){
		users.add(e);
	}
	
	public User findUserById(String id){
		User notFoundUser = users.get(0);
		
		while(usr.hasNext()){
			User user = (User)usr.next();
			if (user.getUserId().equals(id)){
				System.out.println("User found!\nName: " + user.getFullName() + "\n");
				notFoundUser = user;
			}
		}
		return notFoundUser;
	}
}
