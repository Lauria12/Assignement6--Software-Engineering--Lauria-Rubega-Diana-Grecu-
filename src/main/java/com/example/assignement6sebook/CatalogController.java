package com.example.assignement6sebook;

import com.example.assignement6sebook.Book.Book;
import com.example.assignement6sebook.Catalog.Catalog;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/catalog")
public class CatalogController {


    private Catalog catalog;

    @PostMapping(value = "/addBook")
    public void addBook(@RequestParam(value = "book") Book book) {

        catalog.addBook(book);
    }

    @GetMapping(value = "/getBook")
    public Book getBook(@RequestParam(value = "identifier") String identifier) {

        return getBook(identifier);
    }

    @PutMapping(value = "/getBook")
    public void update(@RequestParam(value = "book") Book book) {

        catalog.update(book);
    }

    @DeleteMapping(value = "/delete")
    public void delete(@RequestParam(value = "identifier") String identifier) {

        catalog.delete(identifier);
    }
}
