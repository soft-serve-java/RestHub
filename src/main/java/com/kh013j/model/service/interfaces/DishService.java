package com.kh013j.model.service.interfaces;

import com.kh013j.model.domain.Category;
import com.kh013j.model.domain.Review;
import com.kh013j.model.domain.Dish;
import com.kh013j.model.exception.DishNotFound;

import java.util.List;

public interface DishService {
    Dish create(Dish dish);

    Dish delete(long id);

    List<Dish>  findAll();

    List<Dish>  findAllAvailable();

    //Dish update(Dish dish) throws DishNotFound;
    Dish findById(long id);

    List<Dish> findAllAvailableDishByCategory(Category category);

    List<Dish>  findAllAvailableDishByCategoryOrderByPrice(Category category);

    List<Dish>  findAllAvailableDishByCategoryOrderByPreparingtime(Category category);

    List<Dish>  findAllAvailableDishByCategoryOrderByCalories(Category category);

    List<Dish>  findByAvailableAndNameContaining(String name);

    List<Dish>  findPopular(long id);

    Dish tweakAvailability(long id);

    Dish update(Dish dish) throws DishNotFound;

    List<Review> getReviews(Dish dish);

}
