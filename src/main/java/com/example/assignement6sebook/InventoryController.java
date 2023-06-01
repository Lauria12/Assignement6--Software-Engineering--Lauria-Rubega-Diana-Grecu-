package com.example.assignement6sebook;

import com.example.assignement6sebook.Inventory.Inventory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController
{
    private Inventory inventory;

    @PostMapping(value = "/addBook")
    public void addBook(@RequestParam(value = "identifier") String identifier,
                        @RequestParam(value = "title") String title,
                        @RequestParam(value = "author") String author,
                        @RequestParam(value = "year") int year,
                        @RequestParam(value = "quantity") int quantity) {
        inventory.addBook(identifier, title, author, year, quantity);
    }

    @PutMapping(value = "/{identifier}/quantity")
    public void updateBookQuantity(@PathVariable("identifier") String identifier, @RequestParam(value = "newquantity") int newQuantity) {
        inventory.updateBookQuantity(identifier, newQuantity);
    }
}
