package com.kh013j.restcontrollers;

import com.kh013j.model.domain.Category;
import com.kh013j.model.service.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SessionAttributes("categoryItems")
public class WelcomeController {
    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categoryItems")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Category> getOrderMap() {
        return categoryService.findAll();
    }
    @RequestMapping("/api/hello")
    @CrossOrigin(origins = "http://localhost:4200")
    public String greet() {
        return "Hello from the other side!!!";
    }
}
