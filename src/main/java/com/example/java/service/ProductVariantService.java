package com.example.java.service;

import com.example.java.model.ProductVariant;
import com.example.java.repository.ProductVariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductVariantService {
    @Autowired
    private ProductVariantRepository repository;

    public List<ProductVariant> getAll() {
        return repository.findAll();
    }

    public ProductVariant getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ProductVariant create(ProductVariant variant) {
        return repository.save(variant);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
