package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    private RestTemplate restTemplate = new RestTemplate();


    public String getBookList() {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("book-circuitbreaker");
        String url = "http://localhost:8090/recommended";

        return circuitBreaker.run(() -> restTemplate.getForObject(url, String.class), throwable -> {
            LOGGER.info("error occurred : {}", throwable.getMessage());
            LOGGER.info("Triggering fallback method");
            return getDefaultBookList();
        });
    }

    private String getDefaultBookList() {
            return "Default Result";
    }

}
