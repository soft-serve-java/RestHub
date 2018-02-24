package com.kh013j.controllers;

import com.kh013j.controllers.util.ViewName;
import com.kh013j.model.domain.Dish;
import com.kh013j.model.domain.Order;
import com.kh013j.model.domain.OrderedDish;
import com.kh013j.model.domain.Tables;
import com.kh013j.model.service.interfaces.DishService;
import com.kh013j.model.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@SessionAttributes({"orderMap", "orderedList", "tables"})
public class OrderController {
    @Autowired
    private DishService dishService;

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/addToOrder/{id}")
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
        return new RedirectView(request.getHeader("referer")+"#" + dish.orElse(new Dish()).getId());
    }

    @GetMapping(value = "/removeFromOrder/{id}")
    public RedirectView removeFromOrder(@PathVariable(value = "id") long id,
                                        @ModelAttribute("orderMap") Map<Dish, Integer> orderMap,
                                        HttpServletRequest request) {
        Optional<Dish> dish = Optional.of(dishService.findById(id));
        dish.ifPresent(orderMap::remove);
        return new RedirectView(request.getHeader("referer"));
    }

    @GetMapping(value = "/submitOrder")
    public RedirectView submitOrder(@ModelAttribute("orderMap") Map<Dish, Integer> orderMap,
                                    @ModelAttribute("orderedList") List<OrderedDish> orderedDishes,
                                    @ModelAttribute("tables") Tables table) {
        orderService.onSubmitOrder(table.getCurrentTable(), orderMap);
        orderMap.clear();
        return new RedirectView("/order");
    }

    @GetMapping(value = "/submitOne/{dish}")
    public RedirectView submitOne(@PathVariable(value = "dish") Dish dish,
                                  @ModelAttribute("orderMap") Map<Dish, Integer> orderMap,
                                  @ModelAttribute("orderedList") List<OrderedDish> orderedDishes,
                                  HttpServletRequest request) {
        Order order = orderService.findByTable(1);
        return new RedirectView(request.getHeader("referer"));
    }

    @GetMapping(value = "/order")
    public ModelAndView order(@ModelAttribute("orderMap") Map<Dish, Integer> orderMap,
                              @ModelAttribute("orderedList") List<OrderedDish> orderedDishes,
                              @ModelAttribute("tables") Tables table) {
        Order order = orderService.findByTable(table.getCurrentTable());
        if (order != null) {
            orderedDishes.clear();
            orderedDishes.addAll(order.getOrderedFood());
        }
        //TODO:Решить, что делать с заказами на один стол, поле для ввода номера стола.
        int sumOfAllDishPrices = orderMap.entrySet()
                .stream().mapToInt(e -> e.getKey().getPrice() * e.getValue()).sum()
                + orderedDishes.stream().mapToInt(ordered -> ordered.getDish().getPrice() * ordered.getQuantity()).sum();

        return new ModelAndView(ViewName.ORDER, "ordersTotalAmount", sumOfAllDishPrices);
    }


    @ModelAttribute("orderMap")
    public Map<Dish, Integer> getOrderMap() {
        return new HashMap<>();
    }

    @ModelAttribute("orderedList")
    public List<OrderedDish> getOrderedList() {
        return new ArrayList<>();
    }

    @ModelAttribute("tables")
    public Tables getTableNumber() {
        return new Tables();
    }

    @PostMapping(value = "/setTableNumber")
    public RedirectView set(@RequestParam int selectedNumber,
                            HttpServletRequest request, @ModelAttribute("tables") Tables table) {
        table.setCurrentTable(selectedNumber);
        return new RedirectView("/submitOrder");
    }

    @GetMapping(value = "/increase/{dishId}")
    public RedirectView increaseQuantity(@ModelAttribute("orderMap") Map<Dish, Integer> orderMap,
                                         @PathVariable(value = "dishId") int dishId,
                                         HttpServletRequest request) {
        orderMap.computeIfPresent(dishService.findById(dishId), (k, v) -> v + 1);
        return new RedirectView(request.getHeader("referer"));
    }

    @GetMapping(value = "/reduce/{dishId}")
    public RedirectView reduceQuantity(@ModelAttribute("orderMap") Map<Dish, Integer> orderMap,
                                       @PathVariable(value = "dishId") int dishId,
                                       HttpServletRequest request) {
        orderMap.computeIfPresent(dishService.findById(dishId), (k, v) -> v - 1);
        return new RedirectView(request.getHeader("referer"));
    }
}
