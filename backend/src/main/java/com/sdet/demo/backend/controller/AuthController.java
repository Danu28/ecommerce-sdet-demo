package com.sdet.demo.backend.controller;

import com.sdet.demo.backend.model.User;
import com.sdet.demo.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        boolean valid = service.login(user.getUsername(), user.getPassword());
        return valid ? "SUCCESS" : "FAIL";
    }
}