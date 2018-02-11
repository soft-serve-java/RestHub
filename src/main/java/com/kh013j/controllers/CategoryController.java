package com.kh013j.controllers;

import com.kh013j.controllers.util.ViewName;
import com.kh013j.model.service.interfaces.CategoryService;
import com.kh013j.model.service.interfaces.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CategoryController {
    @Autowired
    private DishService dishService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/menu/{category}", method = RequestMethod.GET)
    public ModelAndView showCategory( @PathVariable(value = "category") String category) {
        return new ModelAndView(ViewName.MENU, "menuItems", dishService.findAllDishByCategory(
                categoryService.findCategoryByName(category)));
    }

    @RequestMapping(value = "/menu/search")
    public ModelAndView search(@RequestParam String searchField){
        return new ModelAndView(ViewName.MENU, "menuItems", dishService.findByNameContaining(searchField));
    }
}
