package com.example.java.controller;

import com.example.java.model.ProductCategory;
import com.example.java.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productCategory")

public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/getAll")
    public List<ProductCategory> getAll() {
        return productCategoryService.getAll();
    }

    @PostMapping("/create")
    public ProductCategory create(@RequestBody ProductCategory pc) {
        return productCategoryService.create(pc);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        productCategoryService.delete(id);
    }
}
