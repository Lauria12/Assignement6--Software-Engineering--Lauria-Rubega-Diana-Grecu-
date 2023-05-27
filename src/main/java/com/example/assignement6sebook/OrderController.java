package com.example.assignement6sebook;

import com.example.assignement6sebook.Order.Order;

import java.util.Date;

public class OrderController {

    private Order order;

    public void setBookIdentifier(String bookIdentifier) {
        order.setBookIdentifier(bookIdentifier);
    }

    public String getBookIdentifier() {
        return order.getBookIdentifier();
    }

    public void setQuantity(int quantity) {

        order.setQuantity(quantity);

    }

    public int getQuantity() {

        return order.getQuantity();
    }

    public void setOrderDate(Date date) {

        order.setOrderDate(date);
    }

    public Date getOrderDate() {

        return order.getOrderDate();
    }

}
