package edu.txstate.library;

import com.sun.xml.internal.bind.v2.TODO;
import org.omg.CORBA.Object;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LibrarySystem {
	private DocumentDirectory mDocumentDirectory;
	private UserDirectory mUserDirectory;
	private LoanTransactionDirectory mLoanTransactionDirectory;
	private static LibrarySystem instance = new LibrarySystem();


	
	private LibrarySystem(){
		//ensure class has single instance
		mDocumentDirectory = DocumentDirectory.getInstance();
		mUserDirectory = UserDirectory.getInstance();
//		mLoanTransactionDirectory = LoanTransactionDirectory.getInstance();
	}
	
	public static LibrarySystem getInstance(){
		return instance;
	}
	public DocumentDirectory getDocumentDirectory(){
		return DocumentDirectory.getInstance();
	}
	public UserDirectory getUserDirectory(){
        return UserDirectory.getInstance();
    }
	public void addDocument(Document doc){
		DocumentDirectory.addDocument(doc);
	}
	public void addUser(User user){
		UserDirectory.addUser(user);
	}
	public ArrayList getUsers(){
		return mUserDirectory.getUsers();
	}
	public void displayUsers(){
		mUserDirectory.displayUsers();
	}
	public void saveData(){
		getUserDirectory().saveData();
	}
	public void performSearch(int type, String query){
		mDocumentDirectory.findDocumentWithQuery(type, query);
	}
	public void loadData(){
        getUserDirectory().loadData();
        getDocumentDirectory().loadData();
	}
}
