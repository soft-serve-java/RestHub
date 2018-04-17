package com.kh013j.restcontrollers;

import com.kh013j.model.domain.Category;
import com.kh013j.model.exception.CategoryNotFound;
import com.kh013j.model.service.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/admin/category")
public class AdminCategoryControllerRest  {

    private CategoryService categoryService;

    @Autowired
    public AdminCategoryControllerRest(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public List<Category> getCategory(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable("id") long id) throws CategoryNotFound {
        return categoryService.findById(id);
    }

    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category){
        return categoryService.create(category);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteCategory(@PathVariable("id") long id) throws CategoryNotFound {
        categoryService.delete(id);
        return true;
    }


    @PostMapping("/edit/{id}")
    public Category editCategory(@RequestBody Category category){
        return categoryService.update(category);
    }
}