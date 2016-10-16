package edu.txstate.library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

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
	public void findDocumentWithQuery(int type, String query){
		// do stuff with query to find document
		boolean notFound = true;
		int i = 0;
		Scanner in = new Scanner(System.in);

		if(type == 1){
			System.out.println("SEARCH RESULTS for " + query);
			for (Document a: documents
				 ) {
				if(a.getTitle().equalsIgnoreCase(query)){
					displayDocument(a);
					System.out.println("Select an option: \n"+
						"1. Checkout Document\n" +
						"2. Not what I'm looking for. Continue Search\n"+
						"3. Exit Search");
					i = InputValidator.validate(3);

					if(i == 1){
						notFound = false;
						LibrarianUI.processCheckout(a);
					}
					else if(i == 2){
						notFound = true;
					}
					else{
						Console.displayUserMenu();
					}
				}
			}
			if(notFound){
				System.out.println("No Results");
			}
		}
		else{
			System.out.println("You are trying to search by author: " + query);
		}

	}
	public void displayDocument(Document doc){
		System.out.println(doc.getTitle() + "     " + doc.getAuthor() + "     " + doc.getNumberOfCopies());
	}
	public void saveData(){

    }

	public void loadData() {

        // LOAD BOOK DATA ----------------------------------------------------------------------------------------------
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

        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
//          TO TEST LOADING CORRECTNESS
//        for (Document doc : documents) {
//            System.out.println("Title: " + doc.getTitle() + "\nAuthor: " + doc.getAuthor());
//        }

        // LOAD JOURNAL DATA -------------------------------------------------------------------------------------------
        try {
            BufferedReader br = new BufferedReader(new FileReader("journals.txt"));
            String fileRead = br.readLine();
            while (fileRead != null) {
                String[] tokenize = fileRead.split("\\t");
                String tempTitle = tokenize[0];
                String tempDate = tokenize[1];
                String tempPublisher = tokenize[2];
                int tempNumCopies = Integer.parseInt(tokenize[3]);
                int tempVol = Integer.parseInt(tokenize[4]);
                int tempNum = Integer.parseInt(tokenize[5]);
                String tempAuthor = tokenize[6];
                String tempArticles = tokenize[7];

                // Create Journal object
                Journal temp = new Journal(tempTitle, tempDate, tempPublisher, tempNumCopies, tempVol, tempNum, tempAuthor);

                //split the articles in tempArticles into separate tokens
                String[] articleArray = tempArticles.split("\\s*,\\s*");

                // add articles to JournalArticles ArrayList
                for (String article : articleArray) {
                    temp.getJournalArticles().add(new JournalArticle(temp, article));
                    //System.out.println("Article added.");
                }
                fileRead = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
