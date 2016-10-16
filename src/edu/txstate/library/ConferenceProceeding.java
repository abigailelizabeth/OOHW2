package edu.txstate.library;

import java.util.ArrayList;

public class ConferenceProceeding extends Book{
    private String location;
    private String date;

    private ArrayList<ConferencePaper> conferencePapers = new ArrayList<ConferencePaper>();

    public ConferenceProceeding(){
        location = "";
        date = "";
    }

    public ConferenceProceeding(String location, String date, String isbn, String title, String publishDate, String publisher, int num, String author){
        super(isbn, title, publishDate, publisher, num, author);
        setLocation(location);
        setDate(date);
    }
    public ArrayList<ConferencePaper> getPapers(){
        return conferencePapers;
    }
    public String getLocation(){
        return this.location;
    }
    public String getDate(){
        return this.date;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public void setDate(String date){
        this.date = date;
    }
}
