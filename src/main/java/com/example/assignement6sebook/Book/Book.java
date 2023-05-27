package com.example.assignement6sebook.Book;

public class Book {
    private String identifier;
    private String title;
    private String author;
    private int year;

    public Book() {
    }

    public Book(String identifier, String title, String author, int year) {
        this.identifier = identifier;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void setIdentifier(String identifier) {

        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {

        this.author = author;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public void setYear(int year) {

        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}
