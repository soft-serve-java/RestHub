package com.kh013j.model.service.interfaces;

import com.kh013j.model.domain.Category;
import com.kh013j.model.domain.Review;
import com.kh013j.model.domain.Dish;
import com.kh013j.model.exception.DishNotFound;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DishService {
    Dish create(Dish dish);

    Dish delete(long id);

    List<Dish>  findAll();

    List<Dish>  findAllAvailable();

    //Dish update(Dish dish) throws DishNotFound;
    Dish findById(long id);

    Page<Dish> findAllAvailableDishByCategory(Category category, Integer pageNumber);

    Page<Dish>  findAllAvailableDishByCategoryOrderByPrice(Category category, Integer pageNumber, String sortingDirection);

    Page<Dish>  findAllAvailableDishByCategoryOrderByPreparingtime(Category category, Integer pageNumber, String sortingDirection);

    Page<Dish>  findAllAvailableDishByCategoryOrderByCalories(Category category, Integer pageNumber, String sortingDirection);

    List<Dish>  findByAvailableAndNameContaining(String name);

    List<Dish>  findPopular(long id);

    Dish tweakAvailability(long id);

    Dish update(Dish dish) throws DishNotFound;

    List<Review> getReviews(Dish dish);

}
