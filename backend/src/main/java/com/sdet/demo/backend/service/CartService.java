package com.sdet.demo.backend.service;

import com.sdet.demo.backend.model.CartItem;
import com.sdet.demo.backend.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository repository;

    public CartService(CartRepository repository) {
        this.repository = repository;
    }

    public CartItem addToCart(CartItem item) {
        return repository.save(item);   // ✅ THIS is what you asked
    }

    public List<CartItem> getCartItems() {
        return repository.findAll();
    }
}