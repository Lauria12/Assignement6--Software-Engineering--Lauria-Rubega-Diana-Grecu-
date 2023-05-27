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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addBook(Book book) {

        catalog.addBook(book);
    }

    @GetMapping(path = "/{identifier}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book getBook(String identifier) {

        return getBook(identifier);
    }

    @PutMapping(path = "/{identifier}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void update(Book book) {

        catalog.update(book);
    }

    @DeleteMapping(path = "/{identifier}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(String identifier) {

        catalog.delete(identifier);
    }
}
