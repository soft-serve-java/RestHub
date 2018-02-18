package com.kh013j.controllers;

import com.kh013j.model.domain.Dish;
import com.kh013j.model.exception.DishNotFound;
import com.kh013j.model.service.ImgurImageService;
import com.kh013j.model.service.interfaces.CategoryService;
import com.kh013j.model.service.interfaces.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;


@Controller
public class AdminDishController {

  @Autowired
  private DishService dishService;

  @Autowired
  private CategoryService categoryService;
    @GetMapping(value = "/admin")
    public String admin(){
        return "Admin";
    }


    @GetMapping(value = "/admin/dish/all")
    public ModelAndView showDish(){
        return new ModelAndView("AdminDish", "dish", dishService.findAll() );
    }


    @GetMapping(value = "/admin/dish/new")
    public ModelAndView dishCreate(){
        return new ModelAndView("DishEditAdd", "dish", new Dish())
                .addObject("category",categoryService.findAll() );
    }


    @GetMapping(value = "/admin/dish/edit/{id}")
    public ModelAndView dishEdit(@PathVariable(value = "id") long id) {
        return new ModelAndView("DishEditAdd", "dish", dishService.findById(id))
                .addObject("category",categoryService.findAll() );
    }

    @GetMapping(value = "/admin/dish/delete/{id}")
    public String dishDelete(@PathVariable(value = "id") long id) {
        dishService.delete(id);
        return "redirect:/admin/dish/all";
    }

    @PostMapping(value = "/admin/dish/save")
    public String dishSaveNew(@Valid @ModelAttribute("dish" )Dish dish, BindingResult dishResult,
                               @RequestParam("pic") MultipartFile file, Model model) throws Exception {
        if (dishResult.hasErrors()) {
            model.addAttribute("category",categoryService.findAll());
            return "DishEditAdd";
        }
        if (file != null && !file.isEmpty()) {
            dish.setPicture(ImgurImageService.uploadImage(file.getBytes()));
        }
        dishService.update(dish);
        return "redirect:/admin/dish/all";

    }
}