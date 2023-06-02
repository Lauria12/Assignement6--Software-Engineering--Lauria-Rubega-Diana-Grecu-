package com.example.assignement6sebook.Order;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TestOrderAPI {

    private RestTemplate restTemplate;
    private String baseUrl;


    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
        baseUrl = "http://localhost:8080/orders";
    }

    @Test
    public void testCreateOrder() {
        String url = baseUrl + "/create";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>("{\"identifier\":\"1\",\"quantity\":2,\"date\":\"2023-06-01\"}", headers);

        ResponseEntity<Void> response = restTemplate.postForEntity(url, request, Void.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }


    @Test
    public void testGetBookIdentifier() {
        String url = baseUrl + "/getBookIdentifier";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    public void testGetQuantity() {
        String url = baseUrl + "/getQuantity";

        ResponseEntity<Integer> response = restTemplate.getForEntity(url, Integer.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    public void testGetOrderDate() {
        String url = baseUrl + "/getOrderDate";

        ResponseEntity<Date> response = restTemplate.getForEntity(url, Date.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }
}
