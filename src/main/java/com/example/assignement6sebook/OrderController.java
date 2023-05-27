package com.example.assignement6sebook;

import com.example.assignement6sebook.Order.Order;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

public class OrderController {

    private Order order;

    public void setBookIdentifier(@RequestParam(value = "identifier") String bookIdentifier) {

        order.setBookIdentifier(bookIdentifier);
    }

    @GetMapping
    public String getBookIdentifier() {

        return getBookIdentifier();
    }

    public void setQuantity(@RequestParam(value = "quantity") int quantity) {

        order.setQuantity(quantity);
    }

    @GetMapping
    public int getQuantity() {

        return getQuantity();
    }


    public void setOrderDate(@RequestParam(value = "date")Date date) {

        order.setOrderDate(date);
    }

    @GetMapping
    public Date getOrderDate() {

        return getOrderDate();
    }

}
