package com.example.assignement6sebook.Inventory;

import com.example.assignement6sebook.Book.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> bookCatalogue;
    private ObjectMapper objectMapper;

    public Inventory() {
        bookCatalogue = new HashMap<>();
        objectMapper = new ObjectMapper();
    }

    public void addBook(String identifier, String title, String author, int year, int quantity) {
        Book book = new Book(identifier, title, author, year);
        bookCatalogue.put(book.getIdentifier(), quantity);
    }

    public void updateBookQuantity(String identifier, int newQuantity) {
        if (bookCatalogue.containsKey(identifier)) {
            bookCatalogue.put(identifier, newQuantity);
        } else {
            System.out.println("Book not found in inventory.");
        }
    }
    public int getBookQuantity(String identifier) {

        return bookCatalogue.getOrDefault(identifier, 0);
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
            bookCatalogue = objectMapper.readValue(json, objectMapper.getTypeFactory().constructMapType(HashMap.class, String.class, Integer.class));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
