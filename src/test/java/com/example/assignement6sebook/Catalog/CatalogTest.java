package com.example.assignement6sebook.Catalog;
import com.example.assignement6sebook.Book.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatalogTest {
    private Catalog catalog;

    @Before
    public void setUp() {
        catalog = new Catalog();
    }

    @After
    public void tearDown() {
        catalog = null;
    }

    @Test
    void testAddBook() {
        catalog.addBook("1", "Le petit Prince", "Antoine de Saint-Exupéry", 1943);
        assertNotNull(catalog.getBook("1"));
    }

    @Test
    void testGetBook() {
        catalog.addBook("1", "Le petit Prince", "Antoine de Saint-Exupéry", 1943);
        Book book = catalog.getBook("1");
        assertNotNull(book);
        assertEquals("Le petit Prince 1", book.getTitle());
        assertEquals("Antoine de Saint-Exupéry", book.getAuthor());
        assertEquals(1943, book.getYear());
    }

    @Test
    void testUpdate() {

        catalog.addBook("1", "Le petit Prince", "Antoine de Saint-Exupéry", 1943);
        catalog.update("1", "Harry Potter et la maison des sorciers", "J.K Rowling", 1943);
        Book book = catalog.getBook("1");
        assertNotNull(book);
        assertEquals("Harry Potter et la maison des sorciers", book.getTitle());
        assertEquals("J.K Rowling", book.getAuthor());
        assertEquals(1943, book.getYear());

    }

    @Test
    void testDelete() {
        catalog.addBook("1", "Harry Potter et la maison des sorciers", "J.K Rowling", 1943);
        catalog.delete("1");
        //Making sure we cannot get the book that have been deleted from the catalog
        assertNull(catalog.getBook("1"));
    }

    @Test
    public void testSerializeBookToJson() {
        catalog.addBook("1", "Le petit Prince", "Antoine de Saint-Exupéry", 2022);
        String json = catalog.serializeBookToJson("1");
        assertNotNull(json);
        // Add assertions for the JSON structure and content if needed
    }

    @Test
    public void testDeserializeBookFromJson() {
        String json = "{\"identifier\":\"1\",\"title\":\"Le petit Prince\",\"author\":\"Antoine de Saint-Exupéry\",\"year\":1943}";
        Book book = catalog.deserializeBookFromJson(json);
        assertNotNull(book);
        assertEquals("Le petit Prince", book.getTitle());
        assertEquals("Antoine de Saint-Exupéry", book.getAuthor());
        assertEquals(1943, book.getYear());
    }

}