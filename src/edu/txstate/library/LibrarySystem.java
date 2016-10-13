package edu.txstate.library;

public class LibrarySystem {
	private DocumentDirectory mDocumentDirectory;
	private UserDirectory mUserDirectory;
	private LoanTransactionDirectory<LoanTransaction> mLoanTransactionDirectory;
	private static LibrarySystem instance = new LibrarySystem();

	
	private LibrarySystem(){
		//ensure class has single instance
		mDocumentDirectory = DocumentDirectory.getInstance();
		mUserDirectory = UserDirectory.getInstance();
//		mLoanTransactionDirectory = LoanTransactionDirectory.getInstance();
	}
	
	public static LibrarySystem getInstance(){
		System.out.println("Yo you made a librarySystem let me test pushing and updating through intellij");
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
	public void saveData(){
		// save the data
	}
}
