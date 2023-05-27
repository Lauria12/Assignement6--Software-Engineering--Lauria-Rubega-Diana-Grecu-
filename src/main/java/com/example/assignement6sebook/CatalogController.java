package com.example.assignement6sebook;

import com.example.assignement6sebook.Book.Book;
import com.example.assignement6sebook.Catalog.Catalog;

public class CatalogController {

    private Catalog catalog;

    public void addBook(Book book) {
        catalog.addBook(book);
    }

    public Book getBook(String identifier) {
        return getBook(identifier);
    }

    public void update(Book book) {
        catalog.update(book);
    }

    public void delete(String identifier) {
        catalog.delete(identifier);
    }

}
