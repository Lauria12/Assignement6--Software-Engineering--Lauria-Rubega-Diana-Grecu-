package com.example.assignement6sebook;

import com.example.assignement6sebook.Order.Order;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/orders")


public class OrderController {
    private Order order;

    @PostMapping(value = "/create")
    public void createOrder(@RequestParam(value = "identifier") String bookIdentifier,
                            @RequestParam(value = "quantity") int quantity,
                            @RequestParam(value = "date") Date date) {
        order.createOrder(bookIdentifier, quantity, date);
    }
    public void setBookIdentifier(@RequestParam(value = "identifier") String bookIdentifier) {

        order.setBookIdentifier(bookIdentifier);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/getBookIdentifier")
    public String getBookIdentifier() {
        return order.getBookIdentifier();
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
