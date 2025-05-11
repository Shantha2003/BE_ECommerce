package com.example.java.service;

import com.example.java.model.Wishlist;
import com.example.java.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {
    @Autowired
        private  WishlistRepository wishlistRepository;

        public List<Wishlist> getAll() {
            return wishlistRepository.findAll();
        }

        public Wishlist getById(Long id) {
            return wishlistRepository.findById(id).orElse(null);
        }

        public Wishlist create(Wishlist wishlist) {
            return wishlistRepository.save(wishlist);
        }

        public void delete(Long id) {
            wishlistRepository.deleteById(id);
        }
    }