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

    /* public Map<Order, OrderedDish> getOrderedDishes(){
         Map<Order, OrderedDish> map = new HashMap<>();
         long orderId;
         for (OrderedDish orderedDish: orderedDishService.findAll()) {
             orderId = orderedDishService.getOrderIdByOrderedDishId(orderedDish.getId());
             map.put(orderService.findById(orderId), orderedDish);
         }

         for (Map.Entry<Order, OrderedDish> entry: map.entrySet()){
             System.out.println(entry);
         }

         return map;
     }
 */
    @GetMapping("api/cook/get/{id}")
    public Order getOrderByOrderedDishId(@PathVariable("id") long id) {
        System.out.println("get"+id);
        Order order = orderService.findById(orderedDishService.getOrderIdByOrderedDishId(id));
        System.out.println("order.wish = " + order.getWish());
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