package com.kh013j.controllers;

import com.kh013j.model.domain.Dish;
import com.kh013j.model.exception.DishNotFound;
import com.kh013j.model.service.ImgurImageService;
import com.kh013j.model.service.interfaces.CategoryService;
import com.kh013j.model.service.interfaces.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@Controller
public class AdminDishController {

  @Autowired
  private DishService dishService;

  @Autowired
  private CategoryService categoryService;
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(){
        return "Admin";
    }


    @RequestMapping(value = "/admin/dish/all", method = RequestMethod.GET)
    public ModelAndView showDish(){
        return new ModelAndView("AdminDish", "dish", dishService.findAll() );
    }


    @RequestMapping(value = "admin/dish/new", method = RequestMethod.GET)
    public ModelAndView dishCreate(){
        return new ModelAndView("DishEditAdd", "dish", new Dish())
                .addObject("category",categoryService.findAll() );
    }


    @RequestMapping(value = "/admin/dish/edit/{id}", method = RequestMethod.GET)
    public ModelAndView dishEdit(@PathVariable(value = "id") long id) {
        return new ModelAndView("DishEditAdd", "dish", dishService.findById(id));
    }

    @RequestMapping(value = "/admin/dish/delete/{id}", method = RequestMethod.POST)
    public String dishDelete(@PathVariable(value = "id") long id) throws DishNotFound {
        dishService.delete(id);
        return "redirect:/admin/dish/all";
    }

    @RequestMapping(value = "/admin/dish/save", method = RequestMethod.POST)
    public String  dishSaveNew(@Valid @ModelAttribute("dish" )Dish dish, BindingResult dishResult,
                               @RequestParam("pic") MultipartFile file,
                               HttpServletResponse response) throws Exception {

        if (file != null && !file.isEmpty()) {
            dish.setPicture(ImgurImageService.uploadImage(file.getBytes()));
        }
        dishService.update(dish);
        return "redirect:/admin/dish/all";

    }
}