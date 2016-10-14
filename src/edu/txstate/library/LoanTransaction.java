package edu.txstate.library;

public class LoanTransaction {
    private long transactionId;
    private User user;
    private Document document;
    private String dueDate;
    private static long counter = 0;

    public LoanTransaction(long id, User user, Document document, String due){
        counter++;
        this.transactionId = id;
        this.user = user;
        this.document = document;
        this.dueDate = due;
    }
    public static long getTransactionNum(){
        return counter;
    }
    public long getTransactionId(){
        return this.transactionId;
    }

    public User getBorrower(){
        return this.user;
    }

    public Document getDocument(){
        return this.document;
    }

    public String getDueDate(){
        return this.dueDate;
    }

    public void displayTransaction(){
        System.out.println("Transaction ID: " + transactionId + "\nUser: " + user.getFullName() + "\nDocument: " + document.getTitle() + "\nDue: " + dueDate);
    }
}
