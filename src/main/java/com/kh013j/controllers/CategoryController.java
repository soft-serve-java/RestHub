package com.kh013j.controllers;

import com.kh013j.controllers.util.ViewName;
import com.kh013j.model.domain.Category;
import com.kh013j.model.domain.Dish;
import com.kh013j.model.service.interfaces.CategoryService;
import com.kh013j.model.service.interfaces.DishService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
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
    public ModelAndView showCategory(@PathVariable(value = "category") String category,
                                     @RequestParam(value = "page", required = false) Integer pageNumber) {
        ModelAndView modelAndView = new ModelAndView(ViewName.MENU);
        if(pageNumber == null || pageNumber < 1) {
            pageNumber = 1;
        }

        Page<Dish> dishPage = dishService.findAllAvailableDishByCategory(categoryService.findCategoryByName(category), pageNumber);

        modelAndView.addObject("maxPages", dishPage.getTotalPages());
        modelAndView.addObject("menuItems", dishPage.getContent());
        modelAndView.addObject("page", pageNumber);
        modelAndView.addObject("category", category);

        return modelAndView;
    }

    @GetMapping(value = "/menu/{category}/sort/{criteria}")
    public ModelAndView layoutgridSortBy(@PathVariable(value = "criteria") String criteria,
                                         @PathVariable(value = "category") String categoryName,
                                         @RequestParam(value = "page", required = false) Integer pageNumber) {
        ModelAndView modelAndView = new ModelAndView(ViewName.MENU);

        if(pageNumber == null || pageNumber < 1) {
            pageNumber = 1;
        }

        Category category = categoryService.findCategoryByName(categoryName);

        Page<Dish> dishPage;

        switch (criteria) {
            case "byPrice":
                dishPage = dishService.findAllAvailableDishByCategoryOrderByPrice(category, pageNumber);
                break;
            case "ByPreparingtime":
                dishPage = dishService.findAllAvailableDishByCategoryOrderByPreparingtime(category, pageNumber);
                break;
            case "ByCalories":
               dishPage = dishService.findAllAvailableDishByCategoryOrderByCalories(category, pageNumber);
               break;
            default:
                dishPage = dishService.findAllAvailableDishByCategory(category, pageNumber);
        }

        modelAndView.addObject("maxPages", dishPage.getTotalPages());
        modelAndView.addObject("menuItems", dishPage.getContent());
        modelAndView.addObject("page", pageNumber);
        modelAndView.addObject("category", category.getName());

        return modelAndView;
    }
}
