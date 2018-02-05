package com.kh013j.model.service.interfaces;

import com.kh013j.model.domain.Dish;
import com.kh013j.model.exception.DishNotFound;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by User on 04.02.2018.
 */
public interface DishService {
    Dish create(Dish dish);
    Dish delete(long id) throws DishNotFound;
    List findAll();
    Dish update(Dish dish) throws DishNotFound;
    Dish findById(long id);
}
