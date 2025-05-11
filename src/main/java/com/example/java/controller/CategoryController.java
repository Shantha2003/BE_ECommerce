package com.example.java.controller;

import com.example.java.model.Category;
import com.example.java.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public List<Category> getAllCategories(@RequestParam Long userId) {
        return categoryService.getAll(userId);
    }

    @PostMapping("/createCategory")
    public Category createCategory(@RequestBody Category category, @RequestParam Long userId) {
        return categoryService.create(category, userId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id, @RequestParam Long userId) {
        return categoryService.getById(id, userId);
    }
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category updatedCategory, @RequestParam Long userId) {
        return categoryService.update(id, updatedCategory, userId);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id, @RequestParam Long userId) {
        categoryService.delete(id, userId);
    }
}
