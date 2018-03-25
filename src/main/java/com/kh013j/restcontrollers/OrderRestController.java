package com.kh013j.restcontrollers;

import com.kh013j.model.domain.Order;
import com.kh013j.model.domain.OrderedDish;
import com.kh013j.model.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderRestController {
    private OrderService orderService;

    @Autowired
    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/table/{id}")
    public Order getOrderDetails(@PathVariable("id") int id){
        return orderService.findByTable(id);
    }

    @PostMapping
    public Order saveOrder(@RequestBody List<OrderedDish> orderedDishes){
        Order order = new Order();
        order.setTime(new Timestamp(new Date().getTime()));
        order.setOrderedFood(orderedDishes);
        order.setTablenumber(1);
        return orderService.create(order);
    }

}
