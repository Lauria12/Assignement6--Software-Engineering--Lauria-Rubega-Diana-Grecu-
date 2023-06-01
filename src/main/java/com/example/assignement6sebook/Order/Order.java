package com.example.assignement6sebook.Order;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

public class Order {
    private String bookIdentifier;
    private int quantity;
    private Date date;
    private ObjectMapper objectMapper; // Jackson ObjectMapper

    public Order() {
        objectMapper = new ObjectMapper();
    }

    public void createOrder(String bookIdentifier, int quantity, Date date) {
        this.bookIdentifier = bookIdentifier;
        this.quantity = quantity;
        this.date = date;
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

    public String toString() {
        return "Order: " + bookIdentifier + ", " + quantity + ", " + date;
    }
}