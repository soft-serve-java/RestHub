package com.kh013j.controllers;

import com.kh013j.controllers.util.ViewName;
import com.kh013j.model.domain.Dish;
import com.kh013j.model.domain.Order;
import com.kh013j.model.domain.OrderedDish;
import com.kh013j.model.domain.Status;
import com.kh013j.model.service.interfaces.DishService;
import com.kh013j.model.service.interfaces.OrderService;
import com.kh013j.model.service.interfaces.OrderedDishService;
import com.kh013j.model.service.interfaces.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.NonUniqueResultException;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.*;

@Controller
@SessionAttributes(value = {"orderMap", "orderedList", "tableNumber"})
public class OrderController {

    @Autowired
    private DishService dishService;

    @Autowired
    private OrderService orderService;
    @Autowired
    private StatusService statusService;
    @Autowired
    private OrderedDishService orderedDishService;

    @RequestMapping(value = "/addToOrder/{id}", method = RequestMethod.GET)
    public RedirectView addToOrder(@PathVariable(value = "id") long id,
                                     @ModelAttribute("orderMap") Map<Dish, Integer> orderMap,
                                     HttpServletRequest request) {
        Optional<Dish> dish = Optional.of(dishService.findById(id));
        dish.ifPresent(d -> {
            if (orderMap.containsKey(d)) {
                orderMap.put(d, orderMap.get(d) + 1);
            } else {
                orderMap.put(d, 1);
            }
        });
        return new RedirectView(request.getHeader("referer"));
    }


    @RequestMapping(value="/removeFromOrder/{id}",method = RequestMethod.GET)
    public RedirectView removeFromOrder(@PathVariable(value = "id") long id,
                                        @ModelAttribute("orderMap") Map<Dish, Integer> orderMap,
                                        HttpServletRequest request) {
        Optional<Dish> dish = Optional.of(dishService.findById(id));
        dish.ifPresent(orderMap::remove);
        return new RedirectView(request.getHeader("referer"));
    }

    @RequestMapping(value = "/submitOrder")
    public RedirectView submitOrder(@ModelAttribute("orderMap") Map<Dish, Integer> orderMap,
                                    @ModelAttribute("orderedList")  List<OrderedDish> orderedDishes,
                                    HttpServletRequest request ) {
        Order order = orderService.findByTable(1);
        if(order!=null) {
            order.getOrderedFood().addAll(createOrderedDishesFromMap(orderMap,order));
           orderService.update(order);
        }else {
            Order newOrder = createOrderFromMap(orderMap);
            orderService.create(newOrder);
        }
        orderMap.clear();
        return new RedirectView(request.getHeader("referer"));
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ModelAndView order(@ModelAttribute("orderMap") Map<Dish, Integer> orderMap,
                              @ModelAttribute("orderedList")  List<OrderedDish> orderedDishes){
            Order order = orderService.findByTable(1);
            if(order!=null) {
                orderedDishes.clear();
                orderedDishes.addAll(order.getOrderedFood());
            }
            //TODO:Решить, что делать с заказами на один стол, поле для ввода номера стола.
        int sumOfAllDishPrices = orderMap.entrySet()
                .stream().mapToInt(e -> e.getKey().getPrice() * e.getValue()).sum()
                + orderedDishes.stream().mapToInt(ordered-> ordered.getDish().getPrice() * ordered.getQuantity()).sum();
        return new ModelAndView(ViewName.ORDER, "ordersTotalAmount", sumOfAllDishPrices);
    }


    @ModelAttribute("orderMap")
    public Map<Dish, Integer> getOrderMap() {
        return new HashMap<>();
    }

    @ModelAttribute("orderedList")
    public List<OrderedDish> getOrdereList() {
        return new ArrayList<>();
    }

    @ModelAttribute("tableNumber")
    public int getTableNumber() {
        return 0;
    }
    private Order createOrderFromMap(Map<Dish, Integer> orderMap){
        Order order = new Order();
        order.setTime(new Timestamp(new Date().getTime()));
        order.setTablenumber(1);
        order.setOrderedFood(createOrderedDishesFromMap(orderMap, order));
        return order;
    }
    private List<OrderedDish> createOrderedDishesFromMap(Map<Dish, Integer> orderMap, Order order){
        List<OrderedDish> orderedDishes = new ArrayList<>();
        for(Map.Entry<Dish, Integer> entry : orderMap.entrySet()) {
            OrderedDish orderedDish = new OrderedDish();
            orderedDish.setDish(entry.getKey());
            orderedDish.setOrder(order);
            orderedDish.setQuantity(entry.getValue());
            Status status = statusService.findByName("preparing");
            orderedDish.setStatus(status);
            orderedDishes.add(orderedDish);
        }
        return orderedDishes;
    }
}