package com.example.assignement6sebook.Order;

import org.junit.jupiter.api.Test;
import com.example.assignement6sebook.Book.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    private Order order;

    @Before
    public void setUp() {
        order = new Order();
    }

    @After
    public void tearDown() {
        order = null;
    }

    @Test
    public void testCreateOrder() {
        String bookIdentifier = "1";
        int quantity = 2;
        Date date = new Date(12,5,2023);

        order.createOrder(bookIdentifier, quantity, date);

        // Verify the order details are set correctly
        assertEquals(bookIdentifier, order.getBookIdentifier());
        assertEquals(quantity, order.getQuantity());
        assertEquals(date, order.getOrderDate());
    }

    @Test
    public void testSerializeOrderToJson() {
        String bookIdentifier = "1";
        int quantity = 2;
        Date date = new Date();

        order.createOrder(bookIdentifier, quantity, date);
        String json = order.serializeOrderToJson();

        // Verify the JSON string is not null
        assertNotNull(json);

    }

    @Test
    public void testDeserializeOrderFromJson() {
        String json = "{\"bookIdentifier\":\"1\",\"quantity\":2,\"date\":1669149347000}";
        Order deserializedOrder = Order.deserializeOrderFromJson(json);

        // Verify the order is deserialized correctly
        assertEquals("1", deserializedOrder.getBookIdentifier());
        assertEquals(2, deserializedOrder.getQuantity());
        assertEquals(1669149347000L, deserializedOrder.getOrderDate().getTime());
    }

    @Test
    public void testToString() {
        String bookIdentifier = "1";
        int quantity = 2;
        Date date = new Date();

        order.createOrder(bookIdentifier, quantity, date);
        String expectedString = "Order: 1, 2, " + date.toString();

        // Verify the toString() method returns the expected string
        assertEquals(expectedString, order.toString());
    }

    @Test
    void createOrder() {
    }

    @Test
    public void testSetBookIdentifier() {
        String bookIdentifier = "123";
        order.setBookIdentifier(bookIdentifier);
        assertEquals(bookIdentifier, order.getBookIdentifier());
    }

    @Test
    public void testGetBookIdentifier() {
        String bookIdentifier = "123";
        order.setBookIdentifier(bookIdentifier);
        assertEquals(bookIdentifier, order.getBookIdentifier());
    }

    @Test
    public void testSetQuantity() {
        int quantity = 5;
        order.setQuantity(quantity);
        assertEquals(quantity, order.getQuantity());
    }

    @Test
    public void testGetQuantity() {
        int quantity = 5;
        order.setQuantity(quantity);
        assertEquals(quantity, order.getQuantity());
    }

    @Test
    public void testSetOrderDate() {
        Date date = new Date();
        order.setOrderDate(date);
        assertEquals(date, order.getOrderDate());
    }

    @Test
    public void testGetOrderDate() {
        Date date = new Date();
        order.setOrderDate(date);
        assertEquals(date, order.getOrderDate());
    }

}