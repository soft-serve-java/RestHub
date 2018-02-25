package com.kh013j.controllers;

import com.kh013j.controllers.util.ViewName;
import com.kh013j.model.domain.Category;
import com.kh013j.model.domain.Dish;
import com.kh013j.model.service.interfaces.CategoryService;
import com.kh013j.model.service.interfaces.DishService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
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
    public ModelAndView showCategory(@PathVariable(value = "category") String category,
                                     @RequestParam(value = "page", required = false) Integer pageNumber) {
        ModelAndView modelAndView = new ModelAndView(ViewName.MENU);
        PagedListHolder<Dish> pagedListHolder = new PagedListHolder<>(
                                            dishService.findAllAvailableDishByCategory(
                                            categoryService.findCategoryByName(category)));
        pagedListHolder.setPageSize(1);
        modelAndView.addObject("maxPages", pagedListHolder.getPageCount());

        if(pageNumber == null || pageNumber < 1 || pageNumber > pagedListHolder.getPageCount()) {
            pageNumber = 1;
            pagedListHolder.setPage(0);
            modelAndView.addObject("menuItems", pagedListHolder.getPageList());
        } else if(pageNumber <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(pageNumber-1);
            modelAndView.addObject("menuItems", pagedListHolder.getPageList());
        }
        modelAndView.addObject("page", pageNumber);
        modelAndView.addObject("category", category);

        return modelAndView;
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
