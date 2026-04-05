package com.sdet.demo.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;
    private int quantity;

    // ✅ Default constructor (MANDATORY)
    public CartItem() {}

    // ✅ Parameterized constructor (optional)
    public CartItem(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    // ✅ Getter for id
    public Long getId() {
        return id;
    }

    // ✅ Getter + Setter for productId (CRITICAL)
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    // ✅ Getter + Setter for quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}