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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/getBook")
    public Book getBook(@RequestParam(value = "identifier") String identifier) {
        return catalog.getBook(identifier);
    }

    @PutMapping(value = "/update/{identifier}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable("identifier") String identifier, @RequestBody Book book) {
        catalog.update(book);
    }

    @DeleteMapping(value = "/delete/{identifier}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("identifier") String identifier) {
        catalog.delete(identifier);
    }

}
