package com.kh013j.restcontrollers;

import com.kh013j.model.domain.*;
import com.kh013j.model.service.interfaces.OrderService;
import com.kh013j.model.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderRestController {
    private OrderService orderService;

    private UserService userService;

    @Autowired
    public OrderRestController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping(value = "/table/{id}")
    public Order getOrderDetails(@PathVariable("id") int id){
        return orderService.findByTable(id);
    }

    @GetMapping(value = "/get-wish/{id}")
    public String getOrderWish(@PathVariable("id") int id){
        return  orderService.findById(id).getWish();
    }

    @PostMapping("/wish")
    public Order setWishToOrder(@RequestParam("id") String id, @RequestBody String wish){
        Order order = orderService.findById(Long.parseLong(id));
        Order updatedOrder = new Order(order, wish);
        order = orderService.update(updatedOrder);

        return order;
    }

    @PostMapping
    public Order saveOrder(@RequestBody List<OrderedDish> orderedDishes,
                           @RequestParam("table") Integer tableNumber,
                           Principal principal){
        User user = null;
        if (principal != null){
            user = userService.findByEmail(principal.getName());
        }
        return orderService.onSubmitOrder(tableNumber, orderedDishes, user);
    }

    @PostMapping("/submitOne")
    public Order submitOne(@RequestBody OrderedDish orderedDish,
                           @RequestParam("table") Integer tableNumber,
                           Principal principal) {
        User user = null;
        if(principal != null) {
            user = userService.findByEmail(principal.getName());
        }
        return orderService.submitOneDish(tableNumber, orderedDish, user);
    }

}
