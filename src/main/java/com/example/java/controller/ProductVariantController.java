package com.example.java.controller;

import com.example.java.model.ProductVariant;
import com.example.java.repository.ProductVariantRepository;
import com.example.java.service.ProductVariantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productVariant")

public class ProductVariantController {
    @Autowired
    private ProductVariantService productVariantService;

    @GetMapping("/allProdVariant")
    public List<ProductVariant> getAll() {
        return productVariantService.getAll();
    }

    @PostMapping("/createVariant")
    public ProductVariant create(@RequestBody ProductVariant variant) {
        return productVariantService.create(variant);
    }

    @DeleteMapping("/deleteVariant/{id}")
    public void delete(@PathVariable Long id) {
        productVariantService.delete(id);
    }
}
