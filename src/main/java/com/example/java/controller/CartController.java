package com.example.java.controller;

import com.example.java.model.Cart;
import com.example.java.repository.CartRepository;
import com.example.java.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cart")

public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("")
    public List<Cart> getAll() {
        return cartService.getAll();
    }

    @PostMapping("/createCart")
    public Cart createCart(@RequestBody Cart cart) {
        return cartService.create(cart);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCart(@PathVariable Long id) {
        return cartService.getById(id);

    }
    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable Long id) {
        cartService.delete(id);
        }
    }
