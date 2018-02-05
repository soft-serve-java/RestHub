package com.kh013j.model.service;

import com.kh013j.model.domain.Category;
import com.kh013j.model.domain.Dish;
import com.kh013j.model.exception.DishNotFound;
import com.kh013j.model.repository.DishRepository;
import com.kh013j.model.service.interfaces.DishService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


public class DishServiceImpl implements DishService {
    @Resource
    private DishRepository dishRepository;

    @Override
    @Transactional
    public Dish create(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    @Transactional
    public Dish findById(long id) {
        return dishRepository.findOne(id);
    }

    @Override
    public List findAllDishByCategoryOrderByPrice(Category category) {
        return dishRepository.findByCategoryOrderByPrice(category);
    }
    @Override
    public List findAllDishByCategoryOrderByPreparingtime(Category category) {
        return dishRepository.findByCategoryOrderByPreparingtime(category);
    }

    @Override
    public List findAllDishByCategoryOrderByCalories(Category category) {
        return dishRepository.findByCategoryOrderByCalories(category);
    }


    @Override
    @Transactional(rollbackFor=DishNotFound.class)
    public Dish delete(long id) throws DishNotFound {
        Dish deletedDish = dishRepository.findOne(id);

        if (deletedDish == null)
            throw new DishNotFound();

        dishRepository.delete(deletedDish);
        return deletedDish;
    }

    @Override
    @Transactional
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    @Transactional(rollbackFor=DishNotFound.class)
    public Dish update(Dish dish) throws DishNotFound {
        Dish updatedDish = dishRepository.findOne(dish.getId());

        if (updatedDish == null)
            throw new DishNotFound();

        updatedDish.setName(dish.getName());
        updatedDish.setDescription(dish.getDescription());
        updatedDish.setWeight(dish.getWeight());
        updatedDish.setCalories(dish.getCalories());
        updatedDish.setPreparingtime(dish.getPreparingtime());
        updatedDish.setPrice(dish.getPrice());
        updatedDish.setCategory(dish.getCategory());
        updatedDish.setPicture(dish.getPicture());
        updatedDish.setAvalibility(dish.isAvalibility());

        return updatedDish;
    }
}
