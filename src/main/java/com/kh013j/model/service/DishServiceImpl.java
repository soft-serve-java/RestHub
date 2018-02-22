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
    public List findAllAvailableDishByCategoryOrderByPrice(Category category) {
        return dishRepository.findByCategoryAndAvailabilityOrderByPrice(category, true);
    }

    @Override
    public List findAllAvailableDishByCategoryOrderByPreparingtime(Category category) {
        return dishRepository.findByCategoryAndAvailabilityOrderByPreparingtime(category,true);
    }

    @Override
    public List findAllAvailableDishByCategoryOrderByCalories(Category category) {
        return dishRepository.findByCategoryAndAvailabilityOrderByCalories(category, true);
    }

    @Override
    @Transactional(rollbackFor = DishNotFound.class)
    public List<Dish> findAllAvailableDishByCategory(Category category) {
        return dishRepository.findAllByCategoryAndAvailability(category, true);
    }

    @Override
    public List<Dish> findByAvailableAndNameContaining(String name) {
        return dishRepository.findByNameContainingIgnoreCaseAndAvailability(name, true);
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
    public List findAllAvailable() {
        return dishRepository.findAllByAvailability(true);
    }

    @Override
    public List<Dish> findPopular(long id) {
        return dishRepository.findDishByPopularCustomQuery(id);
    }


    @Override
    public Dish update(Dish dish) throws DishNotFound {
        return dishRepository.saveAndFlush(dish);
    }

    @Override
    public Dish tweakAvailability(long id) {
        Dish dish = dishRepository.findOne(id);
        if (dish == null) {
            return null;
        }
        dish.setAvailability(!dish.isAvailability());
        dishRepository.saveAndFlush(dish);
        return dish;
    }
}
