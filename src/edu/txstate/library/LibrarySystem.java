package edu.txstate.library;

public class LibrarySystem {
	private DocumentDirectory mDocumentDirectory;
	private UserDirectory<User> mUserDirectory;
	private LoanTransactionDirectory<LoanTransaction> mLoanTransactionDirectory;
	private static LibrarySystem instance = new LibrarySystem();

	
	private LibrarySystem(){
		 //ensure class has single instance
		mDocumentDirectory = DocumentDirectory.getInstance();
//		mUserDirectory = UserDirectory.getInstance();
//		mLoanTransactionDirectory = LoanTransactionDirectory.getInstance();
	}
	
	public static LibrarySystem getInstance(){
		System.out.println("Yo you made a librarySystem let me test pushing and updating through intellij");
		return instance;
	}
	
	public void saveData(){
		// save the data
	}
}
