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
	public Document findDocumentWithQuery(String query){
		// do stuff with query to find document
		Document placeHolder = documents.get(0);
		return placeHolder;
	}
	public void saveData(){
		//do stuff with the file name to write to the file in order to save all the date
		
	}



}
