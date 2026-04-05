package com.sdet.demo.backend.repository;

import com.sdet.demo.backend.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartItem, Long> {
}