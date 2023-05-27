package com.example.assignement6sebook.Order;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

public class Order {
    private String bookIdentifier;
    private int quantity;
    private Date date;
    private ObjectMapper objectMapper; // Jackson ObjectMapper

    public Order(String bookIdentifier, int quantity, Date date) {
        this.bookIdentifier = bookIdentifier;
        this.quantity = quantity;
        this.date = date;
        this.objectMapper = new ObjectMapper();
    }

    public void setBookIdentifier(String bookIdentifier) {

        this.bookIdentifier = bookIdentifier;
    }

    public String getBookIdentifier() {

        return bookIdentifier;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

    public int getQuantity() {

        return quantity;
    }

    public void setOrderDate(Date date) {

        this.date = date;
    }

    public Date getOrderDate() {

        return date;
    }

    public String serializeOrderToJson() {
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Order deserializeOrderFromJson(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, Order.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // Create an Order instance
        Order order = new Order("1", 1, new Date());

        // Serialize the order to JSON
        String json = order.serializeOrderToJson();
        System.out.println(json);

        // Deserialize the order from JSON
        Order deserializedOrder = Order.deserializeOrderFromJson(json);
        System.out.println(deserializedOrder.getBookIdentifier());
        System.out.println(deserializedOrder.getQuantity());
        System.out.println(deserializedOrder.getOrderDate());


    }
}