package com.example.assignement6sebook.Inventory;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestInventoryAPI {

    private RestTemplate restTemplate;
    private String baseUrl;



    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
        baseUrl = "http://localhost:8080/inventory";
    }

    @Test
    public void testAddBook() {
        String url = baseUrl + "/addBook";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>("{\"identifier\":\"1\",\"title\":\"Le petit Prince\",\"author\":\"Antoine de Saint-Exupéry\",\"year\":1943,\"quantity\":10}", headers);

        ResponseEntity<Void> response = restTemplate.postForEntity(url, request, Void.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    public void testUpdateBookQuantity() {
        String identifier = "1";
        int newQuantity = 20;
        String url = baseUrl + "/" + identifier + "/quantity?newquantity=" + newQuantity;

        ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.PUT, null, Void.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }
}
