package com.kh013j.model.service.interfaces;

import com.kh013j.model.domain.Category;
import com.kh013j.model.domain.Dish;
import com.kh013j.model.exception.DishNotFound;

import java.util.List;

public interface DishService {
    Dish create(Dish dish);

    Dish delete(long id);

    List findAll();

    //Dish update(Dish dish) throws DishNotFound;
    Dish findById(long id);

    List findAllDishByCategory(Category category);

    List findAllDishByCategoryOrderByPrice(Category category);

    List findAllDishByCategoryOrderByPreparingtime(Category category);

    List findAllDishByCategoryOrderByCalories(Category category);

    List findByNameContaining(String name);

    List findPopular(long id);

    Dish update(Dish dish) throws DishNotFound;
}
