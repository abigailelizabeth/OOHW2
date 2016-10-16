package edu.txstate.library;

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
		// save the data
	}
	public void performSearch(int type, String query){
		mDocumentDirectory.findDocumentWithQuery(type, query);
	}
}
