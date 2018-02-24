package com.kh013j.controllers;

import com.kh013j.controllers.util.ViewName;
import com.kh013j.model.domain.Category;
import com.kh013j.model.service.interfaces.CategoryService;
import com.kh013j.model.service.interfaces.DishService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private DishService dishService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categoryItems")
    public List<Category> getCategoryItems() {
        return categoryService.findAll();
    }

    @GetMapping(value = "/menu/search")
    public ModelAndView search(@RequestParam String searchField) {
        return new ModelAndView(ViewName.MENU, "menuItems", dishService.findByAvailableAndNameContaining(searchField));
    }

    @GetMapping(value = "/menu/{category}")
    public ModelAndView showCategory(@PathVariable(value = "category") String category) {
        return new ModelAndView(ViewName.MENU, "menuItems", dishService.findAllAvailableDishByCategory(
                categoryService.findCategoryByName(category)));
    }

    @GetMapping(value = "/menu/{category}/sort/{criteria}")
    public ModelAndView layoutgridSortBy(@PathVariable(value = "criteria") String criteria,
                                         @PathVariable(value = "category") String category) {
        switch (criteria) {
            case "byPrice":
                return new ModelAndView(ViewName.MENU, "menuItems",
                        dishService.findAllAvailableDishByCategoryOrderByPrice(categoryService.findCategoryByName(category)));
            case "ByPreparingtime":
                return new ModelAndView(ViewName.MENU, "menuItems",
                        dishService.findAllAvailableDishByCategoryOrderByPreparingtime(categoryService.findCategoryByName(category)));
            case "ByCalories":
                return new ModelAndView(ViewName.MENU, "menuItems",
                        dishService.findAllAvailableDishByCategoryOrderByCalories(categoryService.findCategoryByName(category)));

        }
        return new ModelAndView(ViewName.MENU, "menuItems",
                dishService.findAllAvailable());
    }
}
