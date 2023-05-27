package com.example.assignement6sebook;

import com.example.assignement6sebook.Book.Book;
import com.example.assignement6sebook.Inventory.Inventory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController
{

    private Inventory inventory;


    public void addBook(Book book, int quantity) {

        inventory.addBook(book, quantity);

    }


    public void updateBookQuantity(Book book, int newQuantity) {

        inventory.updateBookQuantity(book, newQuantity);

    }

    public int getBookQuantity(Book book) {

        return getBookQuantity(book);

    }



}
