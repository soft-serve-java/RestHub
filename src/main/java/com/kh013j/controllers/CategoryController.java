package com.kh013j.controllers;

import com.kh013j.controllers.util.ViewName;
import com.kh013j.model.domain.Category;
import com.kh013j.model.service.interfaces.CategoryService;
import com.kh013j.model.service.interfaces.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private DishService dishService;

    @Autowired
    private CategoryService categoryService;
    @ModelAttribute("categoryItems")
    public List<Category> getOrderMap() {
        return categoryService.findAll();
    }

    @RequestMapping(value = "/menu/{category}", method = RequestMethod.GET)
    public ModelAndView showCategory( @PathVariable(value = "category") String category) {
        return new ModelAndView(ViewName.MENU, "menuItems", dishService.findAllDishByCategory(
                categoryService.findCategoryByName(category)));
    }
    @RequestMapping(value = "/menu/{category}/sort/{criteria}", method = RequestMethod.GET)
    public ModelAndView layoutgridSortBy(@PathVariable(value="criteria") String criteria,
                                         @PathVariable(value = "category") String category){
        switch (criteria){
            case "byPrice":
                return new ModelAndView(ViewName.MENU, "menuItems",
                        dishService.findAllDishByCategoryOrderByPrice(categoryService.findCategoryByName(category)));
            case "ByPreparingtime":
                return new ModelAndView(ViewName.MENU, "menuItems",
                        dishService.findAllDishByCategoryOrderByPreparingtime(categoryService.findCategoryByName(category)));
            case "ByCalories":
                return new ModelAndView(ViewName.MENU, "menuItems",
                        dishService.findAllDishByCategoryOrderByCalories(categoryService.findCategoryByName(category)));

        }
        return new ModelAndView(ViewName.MENU, "menuItems",
                dishService.findAll());
    }
}
