package com.sdet.demo.backend.repository;

import com.sdet.demo.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}