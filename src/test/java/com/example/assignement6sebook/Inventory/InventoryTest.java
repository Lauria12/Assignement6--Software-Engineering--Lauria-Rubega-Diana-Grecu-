package com.example.assignement6sebook.Inventory;

import org.junit.jupiter.api.Test;
import com.example.assignement6sebook.Book.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    private Inventory inventory;

    @Before
    public void setUp() {
        inventory = new Inventory();
    }

    @After
    public void tearDown() {
        inventory = null;
    }

    @Test
    public void testAddBook() {
        inventory.addBook("1", "Le petit Prince", "Antoine de Saint-Exupéry",1973 , 10);

        // Verify the book is added correctly
        assertEquals(10, inventory.getBookQuantity("1"));
    }

    @Test
    public void testUpdateBookQuantity() {
        inventory.addBook("1", "Le petit Prince" , "Antoine de Saint-Exupéry", 1973, 10);
        inventory.updateBookQuantity("1", 5);

        // Verify the book quantity is updated correctly
        assertEquals(5, inventory.getBookQuantity("1"));
    }

    @Test
    public void testGetBookQuantity_BookNotFound() {
        // Book is not added to the inventory
        int quantity = inventory.getBookQuantity("1");

        // Verify the default quantity is 0 when book is not found
        assertEquals(0, quantity);
    }

    @Test
    public void testSerializeInventoryToJson() {
        inventory.addBook("1", "Le petit Prince", "Antoine de Saint-Exupéry", 1973, 10);
        String json = inventory.serializeInventoryToJson();

        // Verify the JSON string is not null
        assertNotNull(json);

    }

    @Test
    public void testDeserializeInventoryFromJson() {
        String json = "{\"1\": 10, \"2\": 5}";
        inventory.deserializeInventoryFromJson(json);

        // Verify the book quantities are deserialized correctly
        assertEquals(10, inventory.getBookQuantity("1"));
        assertEquals(5, inventory.getBookQuantity("2"));
    }

}