package com.example.java.service;

import com.example.java.model.Cart;
import com.example.java.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    public ResponseEntity<Cart> getById(Long id) {
        return cartRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public Cart create(Cart cart) {
        return cartRepository.save(cart);
    }

    public void delete(Long id) {
        cartRepository.deleteById(id);
    }
}

