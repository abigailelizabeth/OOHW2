package edu.txstate.library;

import java.util.ArrayList;
import java.util.Iterator;

public class DocumentDirectory{
	private static DocumentDirectory instance = new DocumentDirectory();

	private static ArrayList<Document> documents = new ArrayList<Document>();
	
	private DocumentDirectory(){
		System.out.println("I am a DocumentDirectory Instance. ");
		// ensure class has one instance
	}
	
	public static DocumentDirectory getInstance(){
		return instance;
	}
	
	public static void addDocument(Document doc){
		System.out.println("im trying to add a document");
		documents.add(doc);
	}
	public boolean removeDocument(Document doc){
		return documents.remove(doc);
	}
	public Document findDocumentWithQuery(int type, String query){
		// do stuff with query to find document
		boolean notFound = true;
		if(type == 1){
			System.out.println("SEARCH RESULTS for " + query);
			for (Document a: documents
				 ) {
				if(a.getTitle().equalsIgnoreCase(query)){
					displayDocument(a);
					notFound = false;
				}
			}
			if(notFound){
				System.out.println("No Results");
			}
		}
		else{
			System.out.println("You are trying to search by author: " + query);
		}
		Document placeHolder = documents.get(0);
		return placeHolder;
	}
	public void displayDocument(Document doc){
		System.out.println(doc.getTitle() + "     " + doc.getAuthor() + "     " + doc.getNumberOfCopies());
	}
	public void saveData(){
		//do stuff with the file name to write to the file in order to save all the date
		
	}



}
