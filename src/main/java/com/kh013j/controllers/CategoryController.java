package com.kh013j.controllers;

import com.kh013j.controllers.util.ViewName;
import com.kh013j.model.service.interfaces.CategoryService;
import com.kh013j.model.service.interfaces.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {
    @Autowired
    private DishService dishService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/menu/{category}", method = RequestMethod.GET)
    public ModelAndView showCategory(@PathVariable(value = "category") String category) {
        return new ModelAndView(ViewName.MENU, "menuItems", dishService.findAllDishByCategory(
                categoryService.findCategoryByName(category)));
    }
}
