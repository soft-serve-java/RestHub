package com.kh013j.controllers.admin;

import com.kh013j.model.domain.Order;
import com.kh013j.model.exception.DishNotFound;
import com.kh013j.model.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AdminOrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/admin/order")
    public ModelAndView showOrder(){
        return new ModelAndView("AdminOrder", "order", orderService.findAll() );
    }

    @GetMapping(value = "admin/order/new")
    public ModelAndView orderCreate(){
        return new ModelAndView("OrderAddCreate", "order", new Order());
    }

    @GetMapping(value = "/admin/order/edit/{id}")
    public ModelAndView editCategory(@PathVariable(value = "id") long id) {
        return new ModelAndView("OrderAddCreate", "order", orderService.findById(id));
    }

    @DeleteMapping(value = "/admin/order/{id}")
    public String deleteOrder(@PathVariable(value = "id") long id) throws DishNotFound {
        orderService.delete(id);
        return "redirect:/admin/order";
    }

    @PostMapping(value = "/admin/order/save")
    public String saveNewOrder(@Valid @ModelAttribute("order") Order order, BindingResult orderResult) {
        orderService.update(order);
        return "redirect:/admin/order";
    }
}