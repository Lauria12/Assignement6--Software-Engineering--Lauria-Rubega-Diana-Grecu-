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

    @PostMapping(value = "/addBook")
    public void addBook(@RequestBody Book book, @RequestParam(value = "quantity") int quantity) {
        inventory.addBook(book, quantity);
    }

   // @PutMapping(value = "/updateBookQuantity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping(value = "/{identifier}/quantity")
    public void updateBookQuantity(@PathVariable("identifier") String identifier, @RequestParam(value = "newquantity") int newQuantity) {
        Book book = inventory.getBookByIdentifier(identifier);
        if (book != null) {
            inventory.updateBookQuantity(book, newQuantity);
        } else {

            System.out.println("The book hasn't been found in inventory.");

        }
    }

}
