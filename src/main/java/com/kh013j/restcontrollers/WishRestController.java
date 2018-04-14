package com.kh013j.restcontrollers;

import com.kh013j.model.domain.Order;
import com.kh013j.model.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class WishRestController {
    @Autowired
    private OrderService orderService;

    public WishRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("api/wish/{id}")
    public Order setWish(@PathVariable int id, String wish){
        Order order = orderService.findById(id);

        order.setWish(wish);

        return order;
    }
}
