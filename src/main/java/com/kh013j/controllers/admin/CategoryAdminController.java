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

    @GetMapping(value = "/admin/category/all")
    public ModelAndView showCategories() {
        return new ModelAndView(ViewName.SHOW_CATEGORY,
                "Categories", categoryService.findAll()).addObject("category", new Category());
    }

    @GetMapping(value = "admin/category/new")
    public ModelAndView categoryCreate() {
        return new ModelAndView(ViewName.CATEGORY_EDIT_CREATE, "category", new Category());
    }

    @GetMapping(value = "/admin/category/edit/{id}")
    public ModelAndView categoryEdit(@PathVariable(value = "id") long id) {
        Category category = null;
        try {
            category = categoryService.findById(id);
        } catch (CategoryNotFound categoryNotFound) {
            return new ModelAndView();
        }
        return new ModelAndView(ViewName.CATEGORY_EDIT_CREATE,"Categories", categoryService.findAll())
                .addObject("category", category);
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
