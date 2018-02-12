package com.kh013j.model.service;

import com.kh013j.model.domain.OrderedDish;
import com.kh013j.model.exception.CategoryNotFound;
import com.kh013j.model.exception.DishNotFound;
import com.kh013j.model.repository.OrderedDishRepository;
import com.kh013j.model.service.interfaces.OrderedDishService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderedDishServiceImpl implements OrderedDishService {
    @Resource
    private OrderedDishRepository orderedDishRepository;

    @Override
    @Transactional
    public OrderedDish create(OrderedDish orderedDish) {
        return orderedDishRepository.save(orderedDish);
    }

    @Override
    @Transactional(rollbackFor = CategoryNotFound.class)
    public OrderedDish delete(long id) throws DishNotFound {
        OrderedDish deletedOrderedDish = orderedDishRepository.findOne(id);

        if (orderedDishRepository == null)
            throw new DishNotFound();

        orderedDishRepository.delete(deletedOrderedDish);
        return deletedOrderedDish;
    }

    @Override
    @Transactional
    public OrderedDish update(OrderedDish orderedDish) {
        OrderedDish updatedOrderedDish = orderedDishRepository.findOne(orderedDish.getId());

        updatedOrderedDish.setOrder(orderedDish.getOrder());
        updatedOrderedDish.setDish(orderedDish.getDish());
        updatedOrderedDish.setQuantity(orderedDish.getQuantity());
        updatedOrderedDish.setStatus(orderedDish.getStatus());

        return updatedOrderedDish;
    }

    @Override
    @Transactional
    public OrderedDish findById(long id) {
        return orderedDishRepository.findOne(id);
    }

    @Override
    @Transactional
    public List<OrderedDish> findAll() {
        return orderedDishRepository.findAll();
    }
}
