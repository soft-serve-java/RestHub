package com.kh013j.controllers.admin;

import com.kh013j.controllers.util.ViewName;
import com.kh013j.model.domain.Category;
import com.kh013j.model.domain.User;
import com.kh013j.model.exception.CategoryNotFound;
import com.kh013j.model.exception.DishNotFound;
import com.kh013j.model.service.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
public class CategoryAdminController {
    @Autowired
    CategoryService categoryService;
    @RequestMapping(value = "/admin/category/all", method = RequestMethod.GET)
    public ModelAndView showCategorys(){
        return new ModelAndView(ViewName.SHOW_CATEGORY,
                "Categories", categoryService.findAll());
    }
    @RequestMapping(value = "admin/category/new", method = RequestMethod.GET)
    public ModelAndView categoryCreate(){
        return new ModelAndView(ViewName.CATEGORY_EDIT_CREATE, "category", new Category());
    }

    @RequestMapping(value = "/admin/category/edit/{id}", method = RequestMethod.GET)
    public ModelAndView categoryEdit(@PathVariable(value = "id") long id) {
        Category category = categoryService.findById(id);
        return new ModelAndView(ViewName.CATEGORY_EDIT_CREATE, "category", category);
    }
    @RequestMapping(value = "/admin/category/delete/{id}", method = RequestMethod.POST)
    public String categoryDelete(@PathVariable(value = "id") long id)throws CategoryNotFound {
        categoryService.delete(id);
        return "redirect:/admin/category/all";
    }

    @RequestMapping(value = "/admin/category/save", method = RequestMethod.POST)
    public String  categorySaveNew(@Valid @ModelAttribute("category" )Category category, BindingResult userResult,
                               HttpServletResponse response) throws DishNotFound, IOException {
        categoryService.update(category);
        return "redirect:/admin/category/all";

    }
}
