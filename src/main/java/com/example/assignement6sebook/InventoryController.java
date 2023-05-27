package com.example.assignement6sebook;

import com.example.assignement6sebook.Book.Book;
import com.example.assignement6sebook.Inventory.Inventory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController
{

    private Inventory inventory;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addBook(@RequestParam(value = "book")Book book, @RequestParam(value = "quantity")int quantity) {

        inventory.addBook(book, quantity);

    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateBookQuantity(@RequestParam(value = "book")Book book, @RequestParam(value = "newquantity")int newQuantity) {

        inventory.updateBookQuantity(book, newQuantity);

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public int getBookQuantity(@RequestParam(value = "book")Book book) {

        return getBookQuantity(book);

    }

}
