package com.example.java.service;

import com.example.java.model.SubCategory;
import com.example.java.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryService {
    @Autowired
    private SubCategoryRepository repository;

        public List<SubCategory> getAll() {
            return repository.findAll();
        }

        public SubCategory getById(Long id) {
            return repository.findById(id).orElse(null);
        }


        public SubCategory create(SubCategory subCategory) {
            return repository.save(subCategory);
        }

        public void delete(Long id) {
            repository.deleteById(id);
        }
    }


