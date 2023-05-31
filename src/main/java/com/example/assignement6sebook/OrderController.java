package com.example.assignement6sebook;

import com.example.assignement6sebook.Order.Order;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/orders")


public class OrderController {
    private Order order;

    public void setBookIdentifier(@RequestParam(value = "identifier") String bookIdentifier) {

        order.setBookIdentifier(bookIdentifier);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/getBookIdentifier")
    public String getBookIdentifier() {

        return getBookIdentifier();
    }
    public void setQuantity(@RequestParam(value = "quantity") int quantity) {
        order.setQuantity(quantity);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/getQuantity")
    public int getQuantity() {
        return order.getQuantity();
    }

    public void setOrderDate(@RequestParam(value = "date") Date date) {
        order.setOrderDate(date);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/getOrderDate")
    public Date getOrderDate() {
        return order.getOrderDate();
    }


}
