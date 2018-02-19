package com.kh013j.controllers.admin;

import com.kh013j.controllers.util.ViewName;
import com.kh013j.model.domain.Category;
import com.kh013j.model.exception.CategoryNotFound;
import com.kh013j.model.service.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CategoryAdminController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/admin/category/all", method = RequestMethod.GET)
    public ModelAndView showCategories() {
        return new ModelAndView(ViewName.SHOW_CATEGORY,
                "Categories", categoryService.findAll()).addObject("category", new Category());
    }

    @RequestMapping(value = "admin/category/new", method = RequestMethod.GET)
    public ModelAndView categoryCreate() {
        return new ModelAndView(ViewName.CATEGORY_EDIT_CREATE, "category", new Category());
    }

    @RequestMapping(value = "/admin/category/edit/{id}", method = RequestMethod.GET)
    public ModelAndView categoryEdit(@PathVariable(value = "id") long id) {
        Category category = categoryService.findById(id);
        return new ModelAndView(ViewName.SHOW_CATEGORY,
                "Categories", categoryService.findAll()).addObject("category", category);
    }

    @PostMapping(value = "/admin/category/delete/{id}")
    public String categoryDelete(@PathVariable(value = "id") long id) throws CategoryNotFound {
        categoryService.delete(id);
        return "redirect:/admin/category/all";
    }

    @PostMapping(value = "/admin/category/save")
    public String categorySaveNew(@Valid @ModelAttribute("category") Category category, BindingResult userResult, Model model) {
        if (!userResult.hasErrors()) {
            categoryService.update(category);
        }
        model.addAttribute("Categories", categoryService.findAll());
        return ViewName.SHOW_CATEGORY;
    }
}
