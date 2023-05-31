package com.example.assignement6sebook.Inventory;

import com.example.assignement6sebook.Book.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Book, Integer> bookCatalogue;
    private ObjectMapper objectMapper;

    public Inventory() {
        bookCatalogue = new HashMap<>();
        objectMapper = new ObjectMapper();
    }

    public void addBook(Book book, int quantity) {
        bookCatalogue.put(book, quantity);
    }

    public void updateBookQuantity(Book book, int newQuantity) {
        if (bookCatalogue.containsKey(book)) {
            bookCatalogue.put(book, newQuantity);
        } else {
            System.out.println("Book not found in inventory.");
        }
    }
    public int getBookQuantity(Book book) {

        return bookCatalogue.getOrDefault(book, 0);
    }

    public Book getBookByIdentifier(String identifier) {
        for (Book book : bookCatalogue.keySet()) {
            if (book.getIdentifier().equals(identifier)) {
                return book;
            }
        }
        return null; // Book not found
    }


    public String serializeInventoryToJson() {
        try {
            return objectMapper.writeValueAsString(bookCatalogue);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deserializeInventoryFromJson(String json) {
        try {
            bookCatalogue = objectMapper.readValue(json, objectMapper.getTypeFactory().constructMapType(HashMap.class, Book.class, Integer.class));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


}
