package com.example.assignement6sebook;

import com.example.assignement6sebook.Book.Book;
import com.example.assignement6sebook.Catalog.Catalog;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
    private Catalog catalog;

    @PostMapping(value = "/addBook")
    public void addBook(@RequestParam(value = "identifier") String identifier,
                        @RequestParam(value = "title") String title,
                        @RequestParam(value = "author") String author,
                        @RequestParam(value = "year") int year) {
        catalog.addBook(identifier, title, author, year);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/getBook")
    public Book getBook(@RequestParam(value = "identifier") String identifier) {
        return catalog.getBook(identifier);
    }

    @PutMapping(value = "/update/{identifier}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable("identifier") String identifier,
                       @RequestParam(value = "title") String title,
                       @RequestParam(value = "author") String author,
                       @RequestParam(value = "year") int year) {
        catalog.update(identifier, title, author, year);
    }

    @DeleteMapping(value = "/delete/{identifier}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("identifier") String identifier) {
        catalog.delete(identifier);
    }
}
