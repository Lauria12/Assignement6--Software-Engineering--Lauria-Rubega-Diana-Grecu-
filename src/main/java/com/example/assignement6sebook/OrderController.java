package com.example.assignement6sebook;

import com.example.assignement6sebook.Order.Order;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

public class OrderController {

    private Order order;

    public void setBookIdentifier(String bookIdentifier) {

        order.setBookIdentifier(bookIdentifier);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getBookIdentifier() {

        return getBookIdentifier();
    }

    public void setQuantity(int quantity) {

        order.setQuantity(quantity);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public int getQuantity() {

        return getQuantity();
    }


    public void setOrderDate(Date date) {

        order.setOrderDate(date);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Date getOrderDate() {

        return getOrderDate();
    }

}
