package com.kh013j.controllers.admin;

import com.kh013j.controllers.util.ViewName;
import com.kh013j.model.domain.Dish;
import com.kh013j.model.domain.Image;
import com.kh013j.model.exception.DishNotFound;
import com.kh013j.model.service.ImgurImageService;
import com.kh013j.model.service.interfaces.CategoryService;
import com.kh013j.model.service.interfaces.DishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class AdminDishController {
    @Autowired
    private DishService dishService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ImgurImageService imgurImageService;

    private Logger logger = LoggerFactory.getLogger(AdminDishController.class);

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
        return new ModelAndView(ViewName.DISH_EDIT_ADD, "dish", new Dish())
                .addObject("category",categoryService.findAll() );
    }


    @GetMapping(value = "/admin/dish/edit/{id}")
    public ModelAndView dishEdit(@PathVariable(value = "id") long id) {
        return new ModelAndView(ViewName.DISH_EDIT_ADD, "dish", dishService.findById(id))
                .addObject("category",categoryService.findAll() );
    }

    @PostMapping(value = "/admin/dish/delete/{id}")
    public String dishDelete(@PathVariable(value = "id") long id) {
        dishService.delete(id);
        return "redirect:/admin/dish/all";
    }

    @GetMapping(value = "/admin/dish/tweakAvail/{id}")
    public String tweakAvailability(@PathVariable(value = "id") long id) {
        dishService.tweakAvailability(id);
        return "redirect:/admin/dish/all";
    }

    @GetMapping(value = "/admin/dish/{id}/removeImage/{img_id}")
    public String removeImage(@PathVariable(value = "id") long id,
                              @PathVariable(value = "img_id") long imageId) throws DishNotFound {
        Dish dish = dishService.findById(id);
        dish.getImages().removeIf(img -> img.getId() == imageId);
        dishService.update(dish);
        return "redirect:/admin/dish/edit/" + id;
    }

    @PostMapping(value = "/admin/dish/save")
    public String dishSaveNew(@Valid @ModelAttribute("dish" )Dish dish, BindingResult dishResult,
                              @RequestParam(value = "pic", required = false) List<MultipartFile> files,
                              Model model) throws DishNotFound {
        Dish oldDish = dishService.findById(dish.getId());
        int totalSize = files.size();
        if (oldDish != null && oldDish.getImages() != null) {
            totalSize += oldDish.getImages().size();
        }
        if(totalSize > 5) {
            dishResult.rejectValue("images", "maxSizeImg", "The maximum number of images is 5!");
        }
        if(files.get(0).getSize() == 0) {
            dishResult.rejectValue("images", "maxSizeImg", "You have to upload at least one image!");
        }
        if (dishResult.hasErrors()) {
            model.addAttribute("category",categoryService.findAll());
            return ViewName.DISH_EDIT_ADD;
        }
        if (!files.isEmpty()) {

            uploadImages(dish, files);

            if (oldDish != null && oldDish.getImages() != null) {
                dish.getImages().addAll(0, oldDish.getImages());
            }
        }
        dishService.update(dish);
        return "redirect:/admin/dish/all";
    }

    private void uploadImages(Dish dish, List<MultipartFile> files){
        if (dish.getImages() == null) {
            dish.setImages(new ArrayList<>());
        }
        files.parallelStream().forEach(file -> {
            if (file.getSize() == 0) return;

            Image image = new Image();
            try {
                image.setUrl(imgurImageService.uploadImage(file.getBytes()));
                dish.getImages().add(image);
            } catch (IOException e) {
                logger.error("Something wrong with file", e, file);
            }
        });
    }
}