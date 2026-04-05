package com.sdet.demo.backend.controller;

import com.sdet.demo.backend.model.CartItem;
import com.sdet.demo.backend.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    @PostMapping
    public CartItem addToCart(@RequestBody CartItem item) {
        return service.addToCart(item);   // ✅ DB save
    }

    @GetMapping
    public List<CartItem> getCart() {
        return service.getCartItems();    // ✅ Fetch from DB
    }
}