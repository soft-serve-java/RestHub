package com.kh013j.controllers;

import com.kh013j.controllers.util.ViewName;
import com.kh013j.model.repository.CategoryRepository;
import com.kh013j.model.service.interfaces.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @Autowired
    private DishService dishService;

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {
        return "Welcome";
    }

    @RequestMapping(value = "/layoutgrid", method = RequestMethod.GET)
    public ModelAndView layoutgrid() {
        return new ModelAndView(ViewName.MENU, "menuItems",
                dishService.findAll());
    }

    @RequestMapping(value = "/menu/sort/{criteria}", method = RequestMethod.GET)
    public ModelAndView layoutgridSortBy(@PathVariable(value = "criteria") String criteria) {
        switch (criteria) {
            case "byPrice":
                return new ModelAndView(ViewName.MENU, "menuItems",
                        dishService.findAllDishByCategoryOrderByPrice(categoryRepository.findOne(1L)));
            case "ByPreparingtime":
                return new ModelAndView(ViewName.MENU, "menuItems",
                        dishService.findAllDishByCategoryOrderByPreparingtime(categoryRepository.findOne(1L)));
            case "ByCalories":
                return new ModelAndView(ViewName.MENU, "menuItems",
                        dishService.findAllDishByCategoryOrderByCalories(categoryRepository.findOne(1L)));
        }
        return new ModelAndView(ViewName.MENU, "menuItems",
                dishService.findAll());
    }

    @RequestMapping(value = "/dishdescription/{id}", method = RequestMethod.GET)
    public String dishdescription(Model model, @PathVariable(value = "id") long id) {
        model.addAttribute("dish", dishService.findById(id));
        return ViewName.DISH_DESCRIPTION;
    }
}
