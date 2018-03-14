package com.kh013j.controllers;

import com.kh013j.model.domain.Category;
import com.kh013j.model.exception.CategoryNotFound;
import com.kh013j.model.service.interfaces.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category/all")
    public List<Category> getCategories(){
        return categoryService.findAll();
    }

    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable("id") long id){
        try {
            return categoryService.findById(id);
        } catch (CategoryNotFound categoryNotFound) {
            LOGGER.warn("Category not found by id", id, categoryNotFound);
            return null;
        }
    }

    @PostMapping("/category/add")
    public Category addCategory(@RequestBody Category category){
        return categoryService.create(category);
    }

    @DeleteMapping("category/{id}")
    public Boolean deleteCategory(@PathVariable("id") long id){
        try {
            categoryService.delete(id);
            return true;
        } catch (CategoryNotFound categoryNotFound) {
            LOGGER.warn("Category not found by id for deletion", id, categoryNotFound);
            return false;
        }
    }
}
