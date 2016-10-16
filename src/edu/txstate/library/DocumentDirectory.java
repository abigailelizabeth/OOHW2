package edu.txstate.library;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

	public ArrayList<Document> getDocuments(){
        return documents;
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
		if(type == 1){
			System.out.println("SEARCH RESULTS for " + query);
			for (Document a: documents
				 ) {
				if(a.getTitle().toUpperCase() == query.toUpperCase() ){
					displayDocument(a);
				}
				else{
					System.out.println("No Results");
				}
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

	public void loadData(){
		try {
            // Create Buffered Reader object instance with a FileReader
            BufferedReader br = new BufferedReader(new FileReader("books.txt"));
            // Read the first line from text file
            String fileRead = br.readLine();
            // Loop until all lines are read
            while (fileRead != null) {
                // Use String.split to load a String array with values from each line of
                // the file, using tabs as a delimiter
                String[] tokenize = fileRead.split("\\t");

                String tempISBN = tokenize[0];
                String tempTitle = tokenize[1];
                String tempDate = tokenize[2];
                String tempPublisher = tokenize[3];
                int tempNumCopies = Integer.parseInt(tokenize[4]);
                String tempAuthor = tokenize[5];

                Book temp = new Book(tempISBN, tempTitle, tempDate, tempPublisher, tempNumCopies, tempAuthor);
                getDocuments().add(temp);

                fileRead = br.readLine();
            }
            br.close();

		} catch (FileNotFoundException fnfe){
            System.out.println("File not found");
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        for (Document doc : documents){
            System.out.println(doc.getTitle());
        }
	}



}
