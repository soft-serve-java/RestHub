package com.kh013j.restcontrollers;

import com.kh013j.model.domain.Category;
import com.kh013j.model.exception.CategoryNotFound;
import com.kh013j.model.service.interfaces.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryService categoryService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public List<Category> getCategories(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable("id") long id){
        try {
            Category category = categoryService.findById(id);
            return ResponseEntity.ok(category);
        } catch (CategoryNotFound categoryNotFound) {
            LOGGER.warn("Category not found by id: {0}", id, categoryNotFound);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category){
        return categoryService.create(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable("id") long id){
        try {
            categoryService.delete(id);
            return ResponseEntity.ok().build();
        } catch (CategoryNotFound categoryNotFound) {
            LOGGER.warn("Category not found by id: {0} for deletion", id, categoryNotFound);
            return ResponseEntity.notFound().build();
        }
    }
}
