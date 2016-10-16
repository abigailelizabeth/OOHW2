package edu.txstate.library;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class UserDirectory{
	//private static final String SAVE_FILENAME = "user_directory.txt";
	private static UserDirectory instance = new UserDirectory();
	private static ArrayList<User> users = new ArrayList<User>();
	
//	Iterator<User> usr = users.iterator();
	
	private UserDirectory (){
		System.out.println("I am a UserDirectory Instance.");
		//ensure class has one instance
	}
	
	public static UserDirectory getInstance(){
		return instance;
	}
	
	public static void addUser(User e){
		System.out.println("Adding: " + e.getFullName());
		users.add(e);
		System.out.println("There are " + users.size() + " users");
	}
	public ArrayList<User> getUsers(){
		return users;
	}
	public void displayUsers(){
		for (User a: users
			 ) {
			System.out.println(a.getFullName());

		}
	}

    public void loadData(){
        try{
            // Create Buffered Reader object instance with a FileReader
            BufferedReader br = new BufferedReader(new FileReader("users.txt"));
            // Read the first line from text file
            String fileRead = br.readLine();
            // Loop until all lines are read
            while (fileRead != null){
                // Use String.split to load a String array with values from each line of
                // the file, using whitespace as delimiter
                String[] tokenize = fileRead.split("\\s");

                // Create temp variables for the data types
                String tempfName = tokenize[0];
                String templName = tokenize[1];
                String tempID    = tokenize[2];
                String tempType  = tokenize[3];

                // Create temporary instances of User object
                if(tempType.equals("student")){
                    User temp = new StudentUser(tempfName, templName, tempID);
                    //Add user to UserDirectory arrayList
                    getUsers().add(temp);
                }
                else{
                    User temp = new FacultyUser(tempfName, templName, tempID);
                    getUsers().add(temp);
                }
                fileRead = br.readLine();
            }
            // Close file stream
            br.close();

        } catch (FileNotFoundException fnfe){
            System.out.println("File not found");
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        // Display list of users
        for (User user : users){
            System.out.println(user.getFullName());
        }
    }
	
	public User findUserById(String id){
		User notFoundUser = users.get(0);

//		while(usr.hasNext()){
//			User user = (User)usr.next();
//			if (user.getUserId().equals(id)){
//				System.out.println("User found!\nName: " + user.getFullName() + "\n");
//				notFoundUser = user;
//			}
//		}
		return notFoundUser;
	}
}
