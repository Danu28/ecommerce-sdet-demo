package com.sdet.demo.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        System.out.println("Hello API called");
        return "Backend is working!";
    }
}