package com.kh013j.controllers;

import com.kh013j.controllers.util.ViewName;
import com.kh013j.model.domain.*;
import com.kh013j.model.service.interfaces.DishService;
import com.kh013j.model.service.interfaces.OrderService;
import com.kh013j.model.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.*;

@Controller
@SessionAttributes({"orderMap", "orderedList", "tables"})
public class OrderController {
    @Autowired
    private DishService dishService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;
    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping(value = "/addToOrder/{id}")
    public RedirectView addToOrder(@PathVariable(value = "id") long id,
                                   @ModelAttribute("orderMap") Map<Dish, Integer> orderMap,
                                   HttpServletRequest request) {
        Optional<Dish> dish = Optional.of(dishService.findById(id));
        dish.ifPresent(d -> {
            orderMap.computeIfPresent(d, (k, v) -> ++v);
            orderMap.putIfAbsent(d, 1);
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
                                    @ModelAttribute("tables") Tables table,
                                    Principal principal) {
        User user = null;
        if (principal != null) {
            user = userService.findByEmail(principal.getName());
        }
        orderService.onSubmitOrder(table.getCurrentTable(), orderMap, user);
        orderMap.clear();
        return new RedirectView("/order");
    }

    @GetMapping(value = "/submitOne/{dish}")
    public RedirectView submitOne(@PathVariable(value = "dish") long dishId,
                                  @ModelAttribute("orderMap") Map<Dish, Integer> orderMap,
                                  @ModelAttribute("tables") Tables table,
                                  Principal principal) {
        Dish dish = dishService.findById(dishId);
        if (dish == null) {
            return new RedirectView("/order");
        }
        User user = null;
        if(principal != null) {
            user = userService.findByEmail(principal.getName());
        }
        if(orderMap.containsKey(dish)) {
            orderService.submitOneDish(table.getCurrentTable(), new AbstractMap.SimpleEntry<>(dish, orderMap.get(dish)), user);
        }
        orderMap.remove(dish);
        return new RedirectView("/order");
    }

    @GetMapping(value = "/order")
    public ModelAndView order(@ModelAttribute("orderMap") Map<Dish, Integer> orderMap,
                              @ModelAttribute("orderedList") List<OrderedDish> orderedDishes,
                              @ModelAttribute("tables") Tables table) {
        Order order = orderService.findByTable(table.getCurrentTable());
        if (order != null) {
            orderedDishes.clear();
            Collections.sort(order.getOrderedFood(), Comparator.comparingLong(OrderedDish::getId));
            orderedDishes.addAll(order.getOrderedFood());
        }
        double sumOfAllDishPrices = orderMap.entrySet()
                .stream().mapToDouble(e -> e.getKey().getPrice() * e.getValue().doubleValue()).sum()
                + orderedDishes.stream().mapToDouble(ordered -> ordered.getDish().getPrice() * ordered.getQuantity()).sum();

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

    @PostMapping(value = "/setTableNumber")
    public RedirectView set(@RequestParam int selectedNumber,
                            @ModelAttribute("tables") Tables table) {

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

    @ModelAttribute("tables")
    public Tables getTableNumber() {
        Tables tables = new Tables();
        tables.setCurrentTable(0);
        return tables;
    }
}
