package com.kh013j.restcontrollers;

import com.kh013j.model.domain.Order;
import com.kh013j.model.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderRestController {
    @Autowired
    private OrderService orderService;
    @GetMapping(value = "/{id}")
    public Order getOrderDetails(@PathVariable("id") int id){
        return orderService.findByTable(id);
    }
}
