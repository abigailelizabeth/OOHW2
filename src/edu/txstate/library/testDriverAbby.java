package edu.txstate.library;

public class testDriverAbby {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("testing");
		LibrarySystem alkek = LibrarySystem.getInstance();
		
		Book agile = new Book(9342342L, "skdslfkadj", "Agile", "123123", "jason", 3);
		alkek.addDocument(agile);

		System.out.println(agile.getPublisher());
	}

}
