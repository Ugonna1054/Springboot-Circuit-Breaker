package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class GlobalControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookService.class);


    @ExceptionHandler(HttpClientErrorException.class)
    public void handleUnauthorized (HttpClientErrorException e) {

          LOGGER.info("errror : " + e.getResponseBodyAsString());
         // return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsString());
    }
}
