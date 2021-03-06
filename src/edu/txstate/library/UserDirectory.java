package edu.txstate.library;

//import java.io.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;

public class UserDirectory{
	//private static final String SAVE_FILENAME = "user_directory.txt";
	private static UserDirectory instance = new UserDirectory();
	private static ArrayList<User> users = new ArrayList<User>();
	
//	Iterator<User> usr = users.iterator();
	
	private UserDirectory (){
		//ensure class has one instance
	}
	
	public static UserDirectory getInstance(){
		return instance;
	}
	
	public static void addUser(User e){
		users.add(e);
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
            if (br.readLine() == null) { // Check if input file is empty
                System.out.println("The input file \"users.txt\" is empty. No Users loaded.");
            }
            else {
                // Read the first line from text file
                String fileRead = br.readLine();
                // Loop until all lines are read
                while (fileRead != null) {
                    // Use String.split to load a String array with values from each line of
                    // the file, using whitespace as delimiter

                    String[] tokenize = fileRead.split("\\s");
                    if(tokenize.length != 4){
                        System.out.println("document \"users.txt\" is formatted incorrectly. Fix file format.");
                        br.readLine();
                    }
                    else if(tokenize.length == 4){
                        // Create temp variables for the data types
                        String tempfName = tokenize[0];
                        String templName = tokenize[1];
                        String tempID = tokenize[2];
                        String tempType = tokenize[3];

                        // Create temporary instances of User object
                        if (tempType.equals("student")) {
                            //Add user to UserDirectory arrayList
                            addUser(new StudentUser(tempfName, templName, tempID));
                        } else {
                            addUser(new FacultyUser(tempfName, templName, tempID));
                        }
                        fileRead = br.readLine();
                    }
                }
                // Close file stream
                br.close();
            }
        } catch (FileNotFoundException fnfe){
            System.out.println("File not found");
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        // Display list of users
//        for (User user : users){
//            System.out.println(user.getFullName());
//        }
    }
    //SAVE USERS TO "users.txt"
    public void saveData(){
        try{
            File userFile = new File("users.txt");
            FileOutputStream fos = new FileOutputStream(userFile, false);

            for (User user : users){
                byte[] userBytes = user.toString().getBytes();
                fos.write(userBytes);
            }
            fos.close();
        } catch (FileNotFoundException fnfe){
            System.out.println("File not found.");
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
	
	public User findUserById(String id){
		User user = null;

        for (User a: users
             ) {
            if(a.getUserId().equalsIgnoreCase(id)){
                user = a;
            }
        }
        return user;

	}
}
