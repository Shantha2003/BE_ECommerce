package com.example.java.controller;

import com.example.java.model.Wishlist;
import com.example.java.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {
@Autowired
    private  WishlistService wishlistService;

    @GetMapping("")
    public List<Wishlist> getAll() {
        return wishlistService.getAll();
    }

    @PostMapping("/createWishlist")
    public Wishlist create(@RequestBody Wishlist wishlist) {
        return wishlistService.create(wishlist);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        wishlistService.delete(id);
    }
}
