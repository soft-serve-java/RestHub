package com.kh013j.controllers;

import com.kh013j.controllers.util.ViewName;
import com.kh013j.model.domain.Category;
import com.kh013j.model.domain.Dish;
import com.kh013j.model.service.interfaces.CategoryService;
import com.kh013j.model.service.interfaces.DishService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MenuController {
    private DishService dishService;

    private CategoryService categoryService;

    Logger logger = LoggerFactory.getLogger("a");

    @Autowired
    public MenuController(DishService dishService, CategoryService categoryService) {
        this.dishService = dishService;
        this.categoryService = categoryService;
    }

    @ModelAttribute("categoryItems")
    public List<Category> getCategoryItems() {
        return categoryService.findAll();
    }

    @GetMapping(value = "/menu")
    public ModelAndView search(@RequestParam("search") String searchField) {
        return new ModelAndView(ViewName.MENU, "menuItems", dishService.findByAvailableAndNameContaining(searchField));
    }

    @GetMapping(value = "/menu/{category}")
    public ModelAndView menu(@PathVariable("category") String categoryName,
                             @RequestParam(value = "direction", required = false) String sortingDirection,
                             @RequestParam(value = "page", required = false) Integer pageNumber){
        return menuSortBy("all", categoryName, sortingDirection, pageNumber);
    }

    @GetMapping(value = "/menu/{category}/{criteria}")
    public ModelAndView menuSortBy(@PathVariable(value = "criteria") String criteria,
                                   @PathVariable("category") String categoryName,
                                   @RequestParam(value = "direction", required = false) String sortingDirection,
                                   @RequestParam(value = "page", required = false) Integer pageNumber) {
        ModelAndView modelAndView = new ModelAndView(ViewName.MENU);

        if(pageNumber == null || pageNumber < 1) {
            pageNumber = 1;
        }

        if(sortingDirection == null) {
            sortingDirection = "DESC";
            logger.error(categoryName);
        }

        Category category = categoryService.findCategoryByName(categoryName);

        Page<Dish> dishPage;

        switch (criteria) {
            case "byPrice":
                dishPage = dishService.findAllAvailableDishByCategoryOrderByPrice(category, pageNumber, sortingDirection);
                break;
            case "ByPreparingtime":
                dishPage = dishService.findAllAvailableDishByCategoryOrderByPreparingtime(category, pageNumber, sortingDirection);
                break;
            case "ByCalories":
               dishPage = dishService.findAllAvailableDishByCategoryOrderByCalories(category, pageNumber, sortingDirection);
               break;
            default:
                dishPage = dishService.findAllAvailableDishByCategory(category, pageNumber);
        }

        modelAndView.addObject("maxPages", dishPage.getTotalPages());
        modelAndView.addObject("menuItems", dishPage.getContent());
        modelAndView.addObject("page", pageNumber);
        modelAndView.addObject("category", categoryName);
        modelAndView.addObject("criteria", criteria);
        modelAndView.addObject("direction", sortingDirection);


        return modelAndView;
    }
}
