package com.kh013j.controllers;

import com.kh013j.model.domain.Order;
import com.kh013j.model.domain.Role;
import com.kh013j.model.exception.DishNotFound;
import com.kh013j.model.service.interfaces.OrderService;
import com.kh013j.model.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AdminOrderController {

  @Autowired
  private OrderService orderService;


    @RequestMapping(value = "/admin/order", method = RequestMethod.GET)
    public ModelAndView showOrder(){
        return new ModelAndView("AdminOrder", "order", orderService.findAll() );
    }

    @RequestMapping(value = "admin/order/new", method = RequestMethod.GET)
    public ModelAndView orderCreate(){
        return new ModelAndView("OrderAdd", "order", new Order());
    }

    @RequestMapping(value = "/admin/order/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editCategory(@PathVariable(value = "id") long id) {
        return new ModelAndView("OrderEdit", "order", orderService.findById(id));
    }

    @RequestMapping(value = "/admin/order/delete/{id}", method = RequestMethod.POST)
    public String deleteOrder(@PathVariable(value = "id") long id) throws DishNotFound {
        orderService.delete(id);
        return "redirect:/admin/order";
    }

    @RequestMapping(value = "/admin/order/save", method = RequestMethod.POST)
    public String  SaveNewOrder(@Valid @ModelAttribute("order") Order order, BindingResult orderResult) {
        orderService.update(order);
        return "redirect:/admin/order";
    }
}