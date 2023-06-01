package com.example.assignement6sebook.Catalog;

import com.example.assignement6sebook.Book.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class Catalog {
    private Map<String, Book> books;
    private ObjectMapper objectMapper;

    public Catalog() {
        books = new HashMap<>();
        objectMapper = new ObjectMapper();
    }

    public void addBook(String identifier, String title, String author, int year) {
        Book book = new Book(identifier, title, author, year);
        books.put(identifier, book);
    }

    public Book getBook(String identifier) {
        return books.get(identifier);
    }

    public void update(String identifier, String title, String author, int year) {
        Book book = new Book(identifier, title, author, year);
        books.put(identifier, book);
    }

    public void delete(String identifier) {
        books.remove(identifier);
    }

    public String serializeBookToJson(String identifier) {
        try {
            return objectMapper.writeValueAsString(books.get(identifier));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Book deserializeBookFromJson(String json) {
        try {
            return objectMapper.readValue(json, Book.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
