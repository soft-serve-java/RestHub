package com.kh013j.controllers;

import com.kh013j.controllers.util.ViewName;
import com.kh013j.model.domain.Category;
import com.kh013j.model.service.interfaces.CategoryService;
import com.kh013j.model.service.interfaces.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@SessionAttributes("categoryItems")
public class HelloController {
    @Autowired
    private DishService dishService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categoryItems")
    public List<Category> getOrderMap() {
        return categoryService.findAll();
    }

    @GetMapping(value = "/hello")
    public String sayHello() {
        return "Hello";
    }

    @GetMapping(value = "/welcome**")
    public String welcome() {
        return "Welcome";
    }

    @GetMapping(value = "/layoutgrid")
    public ModelAndView layoutgrid() {
        return new ModelAndView(ViewName.MENU, "menuItems",
                dishService.findAll());
    }
}