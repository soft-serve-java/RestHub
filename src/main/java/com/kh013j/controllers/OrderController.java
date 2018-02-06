package com.kh013j.controllers;

import com.kh013j.model.domain.Dish;
import com.kh013j.model.service.interfaces.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes("orderMap")
public class OrderController {

    @Autowired
    DishService dishService;

    @RequestMapping(value = "/addToOrder/{id}", method = RequestMethod.GET)
    public RedirectView addToOrder(@PathVariable(value = "id") long id,
                                     @ModelAttribute("orderMap") Map<Dish, Integer> orderMap,
                                     HttpServletRequest request) {
        Dish dish = dishService.findById(id);
        if (orderMap.containsKey(dish)) {
            orderMap.put(dish, orderMap.get(dish) + 1);
        } else {
            orderMap.put(dish, 1);
        }
        return new RedirectView(request.getHeader("referer"));
    }

    @RequestMapping(value="/removeFromOrder/{id}",method = RequestMethod.GET)
    public RedirectView removeFromOrder(@PathVariable(value = "id") long id,
                                        @ModelAttribute("orderMap") Map<Dish, Integer> orderMap,
                                        HttpServletRequest request) {
        Dish dish = dishService.findById(id);

        orderMap.remove(dish);
        return new RedirectView(request.getHeader("referer"));
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String order(){
        return "Cart";
    }


    @ModelAttribute("orderMap")
    public Map<Dish, Integer> getVisitor () {
        return new HashMap<>();
    }
}
