package edu.txstate.library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class DocumentDirectory {
    private static DocumentDirectory instance = new DocumentDirectory();

    private static ArrayList<Document> documents = new ArrayList<Document>();

    private DocumentDirectory() {
        // ensure class has one instance
    }

    public static DocumentDirectory getInstance() {
        return instance;
    }

    public ArrayList<Document> getDocuments() {
        return documents;
    }

    public static void addDocument(Document doc) {
        System.out.println("im trying to add a document");
        documents.add(doc);
    }

    public boolean removeDocument(Document doc) {
        return documents.remove(doc);
    }

    public void findDocumentWithQuery(int type, String query) {
        // do stuff with query to find document
        boolean notFound = true;
        int i = 0;
        Scanner in = new Scanner(System.in);

        if (type == 1) {
            System.out.println("SEARCH RESULTS for " + query);
            for (Document a : documents
                    ) {
                if (a.getTitle().equalsIgnoreCase(query)) {
                    displayDocument(a);
                    notFound = false;
                    if (LibrarySystem.getInstance().getActiveUser() != null) {
                        System.out.println("Select an option: \n" +
                                "1. Checkout Document\n" +
                                "2. Not what I'm looking for. Continue Search\n" +
                                "3. Exit Search");
                        i = InputValidator.validate(3);

                        if (i == 1) {
                            LibrarianUI.processCheckout(a);
                            break;
                        } else if (i == 2) {
                            notFound = true;
                        } else {
                            Console.displayUserMenu();
                        }
                    }
                }
            }
            if (notFound) {
                System.out.println("No Results");
            }

            if (LibrarySystem.getInstance().getActiveUser() == null) {
                System.out.println("Select an option: \n" +
                        "1. Exit Search");
                i = InputValidator.validate(1);
                if (i == 1) {
                    Console.displayGuestMenu();
                }
            }
        } else {
            System.out.println("SEARCH RESULTS for " + query);
            for (Document a : documents
                    ) {
                if (a.getAuthor().equalsIgnoreCase(query)) {
                    displayDocument(a);
                    notFound = false;
                    if (LibrarySystem.getInstance().getActiveUser() != null) {
                        System.out.println("Select an option: \n" +
                                "1. Checkout Document\n" +
                                "2. Not what I'm looking for. Continue Search\n" +
                                "3. Exit Search");
                        i = InputValidator.validate(3);

                        if (i == 1) {
                            LibrarianUI.processCheckout(a);
                            break;
                        } else if (i == 2) {
                            notFound = true;
                        } else {
                            Console.displayUserMenu();
                        }
                    }
                }
            }
            if (notFound) {
                System.out.println("No Results");
            }

            if (LibrarySystem.getInstance().getActiveUser() == null) {
                System.out.println("Select an option: \n" +
                        "1. Exit Search");
                i = InputValidator.validate(1);
                if (i == 1) {
                    Console.displayGuestMenu();
                }
            }
        }

    }

    public void displayDocument(Document doc) {
        System.out.println(doc.getTitle() + "     " + doc.getAuthor() + "     " + doc.getNumberOfCopies());
    }

    public void saveData() {
        try {

            File bookFile = new File("books.txt");
            bookFile.createNewFile(); // if file already exists, will do nothing
            File journalFile = new File("journals.txt");
            journalFile.createNewFile(); // if file already exists will do nothing
            File conferenceFile = new File("conferences.txt");
            conferenceFile.createNewFile(); // if file already exists will do nothing
            FileOutputStream fos = new FileOutputStream(bookFile, false);
            FileOutputStream jos = new FileOutputStream(journalFile, false);
            FileOutputStream cos = new FileOutputStream(conferenceFile, false);

            for (Document doc : documents) {

                Document returned = doc;
                if (doc instanceof ConferenceProceeding) {
                    byte[] conferenceBytes = doc.toString().getBytes();
                    cos.write(conferenceBytes);
                }
                else if (doc instanceof Book) {
                    byte[] bookBytes = doc.toString().getBytes();
                    fos.write(bookBytes);
                }
                else if(doc instanceof Journal) {
                    byte[] journalBytes = doc.toString().getBytes();
                    jos.write(journalBytes);
                }

            }
            fos.close();
            jos.close();
            cos.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("File Not Found.");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void loadData() {

        // LOAD BOOK DATA ----------------------------------------------------------------------------------------------
        try {
            // Create Buffered Reader object instance with a FileReader
            BufferedReader br = new BufferedReader(new FileReader("books.txt"));
            // Read the first line from text file
            if (br.readLine() == null) { // Check if input file is empty
                System.out.println("The input file \"books.txt\" is empty. No Book Documents loaded.");
            }
            else {
                String fileRead = br.readLine();
                // Loop until all lines are read
                while (fileRead != null) {
                    // Use String.split to load a String array with values from each line of
                    // the file, using tabs as a delimiter
                    String[] tokenize = fileRead.split("\\t");
                    if (tokenize.length != 6) {
                        fileRead = br.readLine();

                    } else if (tokenize.length == 6) {
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
                }
                br.close();
            }
            } catch(FileNotFoundException fnfe){
                System.out.println("File not found. No book data was found.");
            } catch(IOException ioe){
                ioe.printStackTrace();
            }

//          TO TEST LOADING CORRECTNESS
//        for (Document doc : documents) {
//            System.out.println("Title: " + doc.getTitle() + "\nAuthor: " + doc.getAuthor());
//        }

        // LOAD JOURNAL DATA -------------------------------------------------------------------------------------------
        try {
            BufferedReader br = new BufferedReader(new FileReader("journals.txt"));
            if (br.readLine() == null) { // Check if input file is empty
                System.out.println("The input file \"journals.txt\" is empty. No Journal Documents loaded.");
            }
            else {
                String fileRead = br.readLine();
                while (fileRead != null) {
                    String[] tokenize = fileRead.split("\\t");
                    if(tokenize.length != 8){
                        System.out.println("Document \"journals.txt\" is formatted incorrectly. Fix file format.");
                        fileRead = br.readLine();
                    }
                    else if (tokenize.length == 8) {
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
                        }
                        getDocuments().add(temp);
                        fileRead = br.readLine();
                    }
                }
                br.close();
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found, no journal data was loaded.");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        // LOAD CONFERENCE DATA ----------------------------------------------------------------------------------------
        try {
        // Create Buffered Reader object instance with a FileReader
        BufferedReader br = new BufferedReader(new FileReader("conferences.txt"));
            if (br.readLine() == null) { // Check if input file is empty
                System.out.println("The input file \"conferences.txt\" is empty. No Conference Documents loaded.");
            }
            else {
                // Read the first line from text file
                String fileRead = br.readLine();
                // Loop until all lines are read
                while (fileRead != null) {
                    // Use String.split to load a String array with values from each line of
                    // the file, using tabs as a delimiter
                    String[] tokenize = fileRead.split("\\t");
                    if (tokenize.length != 8) {
                        System.out.println("Document \"conferences.txt\" is formatted incorrectly. Fix file format.");
                        fileRead = br.readLine();
                    } else if (tokenize.length == 8) {

                        String location = tokenize[0];
                        String date = tokenize[1];
                        String isbn = tokenize[2];
                        String title = tokenize[3];
                        String publishdate = tokenize[4];
                        String publisher = tokenize[5];
                        int num = Integer.parseInt(tokenize[6]);
                        String author = tokenize[7];

                        ConferenceProceeding temp = new ConferenceProceeding(location, date, isbn, title, publishdate, publisher, num, author);
                        getDocuments().add(temp);

                        fileRead = br.readLine();
                    }
                }
                br.close();
            }
        } catch (FileNotFoundException fnfe) {
        System.out.println("File not found. No book data was found.");
        } catch (IOException ioe) {
        ioe.printStackTrace();
        }
    }
}