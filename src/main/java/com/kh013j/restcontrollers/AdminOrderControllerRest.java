package com.kh013j.restcontrollers;

import com.kh013j.model.domain.Order;
import com.kh013j.model.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@CrossOrigin("*")
@RestController
public class AdminOrderControllerRest {

    private OrderService orderService;

    @Autowired
    public AdminOrderControllerRest(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/api/admin/order")
    public List<Order> getDish(){
        return orderService.findAll();
    }

    @DeleteMapping("api/admin/order/delete/{id}")
    public boolean deleteOrder(@PathVariable("id") long id){
        orderService.delete(id);
        System.out.println(id);
        return true;
    }

}
