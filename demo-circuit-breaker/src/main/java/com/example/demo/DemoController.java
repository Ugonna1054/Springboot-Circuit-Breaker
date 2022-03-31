package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private BookService service;

    @GetMapping("/albums")
    public String albums() {
        return service.getBookList();
    }
}

























//    @Value("${welcome.txt}")
//    private String welcomeText;
//
//
//    @GetMapping("/welcome")
//    public String welcome () {
//        return "Welcome to this demo project " + welcomeText;
//    }