package com.example.java.service;

import com.example.java.model.Category;
import com.example.java.model.User;
import com.example.java.repository.CategoryRepository;
import com.example.java.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    @Autowired
    private UserRepository userRepository;

    private boolean isAdmin(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        return user != null && "ADMIN".equalsIgnoreCase(user.getRole());
    }
    public List<Category> getAll(Long userId) {
        if (!isAdmin(userId)) throw new RuntimeException("Access denied");
        return categoryRepository.findAll();
    }

    public ResponseEntity<Category> getById(Long id, Long userId) {
        if (!isAdmin(userId)) throw new RuntimeException("Access denied");
        return categoryRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public Category create(Category category, Long userId) {
        if (!isAdmin(userId)) throw new RuntimeException("Access denied");
        User user = userRepository.findById(userId).orElseThrow();
        category.setCreatedBy(user);
        category.setCreatedAt(LocalDateTime.now());
        return categoryRepository.save(category);
    }
    public Category update(Long id, Category updatedCategory, Long userId) {
        if (!isAdmin(userId)) throw new RuntimeException("Access denied");

        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingCategory.setCatgName(updatedCategory.getCatgName());
        existingCategory.setUpdatedAt(LocalDateTime.now());
        existingCategory.setUpdatedBy(user);

        return categoryRepository.save(existingCategory);
    }

    public void delete(Long id, Long userId) {
        if (!isAdmin(userId)) throw new RuntimeException("Access denied");
        categoryRepository.deleteById(id);
    }
}

