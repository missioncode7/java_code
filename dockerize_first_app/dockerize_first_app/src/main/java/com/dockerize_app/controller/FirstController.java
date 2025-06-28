package com.dockerize_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class FirstController {
    
    @GetMapping
    public String sayHello() {
        return "Hello from Dockerized Spring Boot App";
    }
}
