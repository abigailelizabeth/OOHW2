package edu.txstate.library;

public class JournalArticle {

    private String articleTitle;
    private Journal parentJournal;
    public JournalArticle(){

    }
    public JournalArticle(Journal parentJournal, String title){
        this.articleTitle = title;
        this.parentJournal = parentJournal;
    }

    public Journal getParentJournal(){
        return parentJournal;
    }
}
