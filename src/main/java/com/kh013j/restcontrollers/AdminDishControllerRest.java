package com.kh013j.restcontrollers;

import com.kh013j.model.domain.Dish;
import com.kh013j.model.domain.User;
import com.kh013j.model.service.interfaces.DishService;
import com.kh013j.model.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class AdminDishControllerRest {

    private DishService dishService ;

    @Autowired
    public AdminDishControllerRest(DishService dishService){
        this.dishService = dishService;
    }

    @GetMapping ("/api/admin/dish/all")
    public List<Dish> getDish(){
        return dishService.findAll();
    }

    @GetMapping("/api/admin/dish/{id}")
    public Dish fetDish(@PathVariable("id") long id){
        return dishService.findById(id);
    }

    @PostMapping("/api/admin/dish/add")
    public Dish addDish(@RequestBody Dish dish){
        return dishService.create(dish);
    }

    @DeleteMapping("/api/admin/dish/{id}")
    public Boolean deleteDish(@PathVariable("id") long id){
        dishService.delete(id);
        return true;
    }
}
