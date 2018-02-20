package com.kh013j.model.service.interfaces;

import com.kh013j.model.domain.Category;
import com.kh013j.model.domain.Dish;
import com.kh013j.model.exception.DishNotFound;

import java.util.List;

public interface DishService {
    Dish create(Dish dish);

    Dish delete(long id);

    List findAll();

    List findAllAvailable();

    //Dish update(Dish dish) throws DishNotFound;
    Dish findById(long id);

    List findAllAvailableDishByCategory(Category category);

    List findAllAvailableDishByCategoryOrderByPrice(Category category);

    List findAllAvailableDishByCategoryOrderByPreparingtime(Category category);

    List findAllAvailableDishByCategoryOrderByCalories(Category category);

    List findByAvailableAndNameContaining(String name);

    List findPopular(long id);

    Dish tweakAvailability(long id);

    Dish update(Dish dish) throws DishNotFound;
}
