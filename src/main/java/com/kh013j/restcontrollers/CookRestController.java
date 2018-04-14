package com.kh013j.restcontrollers;

import com.kh013j.model.domain.Order;
import com.kh013j.model.domain.OrderedDish;
import com.kh013j.model.domain.Status;
import com.kh013j.model.service.interfaces.OrderService;
import com.kh013j.model.service.interfaces.OrderedDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class CookRestController {
    @Autowired
    private OrderedDishService orderedDishService;

    @Autowired
    private OrderService orderService;

    public CookRestController(OrderedDishService orderedDishService) {
        this.orderedDishService = orderedDishService;
    }

    @GetMapping("api/cook")
    public List<OrderedDish> getOrderedDishes() {
        return orderedDishService.findAll();
    }

    @GetMapping("api/cook/get/{id}")
    public Order getOrderByOrderedDishId(@PathVariable("id") long id) {
        Order order = orderService.findById(orderedDishService.getOrderIdByOrderedDishId(id));
        return order;
    }

    @PostMapping("api/cook/{id}")
    public List<OrderedDish> changeOrderedDishStatus(@PathVariable("id") long id) {
        OrderedDish orderedDish = orderedDishService.findById(id);

        if (orderedDish.getStatus().getName().equals(Status.PREPARING)) {
            orderedDishService.setCooking(orderedDish.getId());
        } else if (orderedDish.getStatus().getName().equals(Status.COOKING)) {
            orderedDishService.setDone(orderedDish.getId());
        }
        return orderedDishService.findAll();
    }
}