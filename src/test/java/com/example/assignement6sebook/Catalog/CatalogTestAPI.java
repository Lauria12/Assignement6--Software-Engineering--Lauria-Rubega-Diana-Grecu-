package com.example.assignement6sebook.Catalog;

import com.example.assignement6sebook.Book.Book;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class CatalogTestAPI {
    private Catalog catalog;
    private RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8080/catalog";

    //There is no real need to test getters and setters, I just did it to have a full coverage test

    @Before
    public void setUp() {
        catalog = new Catalog();
        restTemplate = new RestTemplate();
    }

    @Test
    public void testAddBookEndpoint() {
        String url = baseUrl + "/addBook";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String requestBody = "{\"identifier\":\"1\",\"title\":\"Le petit Prince\",\"author\":\"Antoine de Saint-Exupéry\",\"year\":1943}";
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Void> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Void.class);

        // Perform assertions on the response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    }

    @Test
    public void testGetBookEndpoint() {
        String url = baseUrl + "/getBook?identifier=1";

        ResponseEntity<Book> responseEntity = restTemplate.getForEntity(url, Book.class);

        // Perform assertions on the response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());

    }

    @Test
    public void testUpdateEndpoint() {
        String url = baseUrl + "/update/1";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String requestBody = "{\"title\":\"Harry Potter et la maison des sorciers\",\"author\":\"J.K Rowling\",\"year\":1943}";
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Void> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Void.class);

        // Perform assertions on the response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    }

    @Test
    public void testDeleteEndpoint() {
        String url = baseUrl + "/delete/1";

        ResponseEntity<Void> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);

        // Perform assertions on the response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    }
}