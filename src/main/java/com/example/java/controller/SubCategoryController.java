package com.example.java.controller;

import com.example.java.model.SubCategory;
import com.example.java.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/subcategory")
public class SubCategoryController {
    @Autowired
    private SubCategoryService subCategoryService;

    @GetMapping("")
    public List<SubCategory> getAll(){
        return subCategoryService.getAll();
    }

    @PostMapping("/createSubCategory")
    public SubCategory create(@RequestBody SubCategory subCat) {
        return subCategoryService.create(subCat);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        subCategoryService.getById(id);
    }
}
