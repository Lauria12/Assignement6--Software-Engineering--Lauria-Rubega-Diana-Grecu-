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

        public void addBook(Book book) {

            books.put(book.getIdentifier(), book);
        }

        public Book getBook(String identifier) {

            return books.get(identifier);
        }

        public void update(Book book) {

            books.put(book.getIdentifier(), book);
        }

        public void delete(String identifier) {

            books.remove(identifier);
        }

        public String serializeBookToJson(Book book) {
            try {
                return objectMapper.writeValueAsString(book);
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

        public static void main(String[] args) {
            // Create a Catalog instance
            Catalog catalog = new Catalog();

            // Add books to the catalog
            catalog.addBook(new Book("1", "Book 1", "Author 1", 2021));
            catalog.addBook(new Book("2", "Book 2", "Author 2", 2022));

            // Serialize the book to JSON
            String json = catalog.serializeBookToJson(new Book("1", "Book 1", "Author 1", 2021));
            System.out.println(json);

            // Deserialize the JSON back into the book
            Book book = catalog.deserializeBookFromJson(json);
            System.out.println("Book: " + book);

            // Retrieve the book from the catalog
            Book bookFromCatalog = catalog.getBook("1");
            System.out.println("Book from catalog: " + bookFromCatalog);

            // Update the book in the catalog
            catalog.update(new Book("1", "Book 1", "Author 1", 2021));
            System.out.println("Updated book: " + catalog.getBook("1"));

            // Delete the book from the catalog
            catalog.delete("1");
            System.out.println("Deleted book: " + catalog.getBook("1"));

        }
    }

