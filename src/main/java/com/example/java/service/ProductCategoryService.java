package com.example.java.service;

import com.example.java.model.ProductCategory;
import com.example.java.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public List<ProductCategory> getAll() {
        return productCategoryRepository.findAll();
    }

    public ProductCategory getById(Long id) {
        return productCategoryRepository.findById(id).orElse(null);
    }

    public ProductCategory create(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    public void delete(Long id) {
        productCategoryRepository.deleteById(id);
    }
}
