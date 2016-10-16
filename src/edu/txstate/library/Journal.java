package edu.txstate.library;

import java.util.ArrayList;

public class Journal extends ShortTermDocument {
    private int mVolume;
    private int mNumber;

    private ArrayList<JournalArticle> journalArticles = new ArrayList<JournalArticle>();

    public Journal(String title, String publishDate, String publisher, int numCopies, int volume, int number, String author){
        super(title, publishDate, publisher, numCopies, author);
        this.setVolume(volume);
        this.setNumber(number);

        journalArticles.add(new JournalArticle(this, "Test Article"));
    }

    public void setVolume(int volume){
        this.mVolume = volume;
    }

    public void setNumber(int number){
        this.mNumber = number;
    }


    public int getVolume(){
        return this.mVolume;
    }

    public int getNumber(){
        return this.mNumber;
    }

    public ArrayList<JournalArticle> getJournalArticles(){
        return journalArticles;
    }
}
