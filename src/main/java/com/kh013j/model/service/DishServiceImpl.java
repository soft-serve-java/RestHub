package com.kh013j.model.service;

import com.kh013j.model.domain.Category;
import com.kh013j.model.domain.Dish;
import com.kh013j.model.exception.DishNotFound;
import com.kh013j.model.repository.DishRepository;
import com.kh013j.model.service.interfaces.DishService;
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
    @Transactional(rollbackFor = DishNotFound.class)
    public List<Dish> findAllDishByCategory(Category category) {
        return dishRepository.findAllByCategory(category);
    }

    @Override
    public List<Dish> findByNameContaining(String name) {
        return dishRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    @Transactional(rollbackFor = DishNotFound.class)
    public Dish delete(long id)  {
        Dish deletedDish = dishRepository.findOne(id);
        dishRepository.delete(deletedDish);
        return deletedDish;
    }

    @Override
    @Transactional
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    @Override
    public List<Dish> findPopular(long id) {
        return dishRepository.findDishByPopularCustomQuery(id);
    }


    @Override
    public Dish update(Dish dish) throws DishNotFound {
        return dishRepository.saveAndFlush(dish);
    }


}
