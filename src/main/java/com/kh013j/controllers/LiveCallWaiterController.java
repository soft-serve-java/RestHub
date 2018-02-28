package com.kh013j.controllers;

import java.sql.Timestamp;
import java.util.List;

import com.kh013j.controllers.util.ViewName;
import com.kh013j.model.domain.CallForWaiter;
import com.kh013j.model.domain.Order;
import com.kh013j.model.domain.Tables;
import com.kh013j.model.domain.User;
import com.kh013j.model.service.CallForWaiterService;
import com.kh013j.model.service.interfaces.OrderService;
import com.kh013j.model.service.interfaces.OrderedDishService;
import com.kh013j.model.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LiveCallWaiterController {

    @Autowired
    private CallForWaiterService service;

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderedDishService orderedDishService;

    @MessageMapping("/waiterCall")
    @SendTo("waiter/tables")
    public List<Tables> getWaitingTables(){
        return orderService.findTableInfoForWaiter();
    }

    @GetMapping("/waiter/tab")
    public ModelAndView getWaiter(){
        return  new ModelAndView("Notify", "tables", new Tables());
    }

    //https://stackoverflow.com/questions/10902775/spring-shutdown-event-that-fires-immediately-before-applicationcontext-is-destro

    @PostMapping("/callWaiterClient")
    @ResponseBody
    public void callForWaiter(@RequestParam int table) {
        List<CallForWaiter> callForWaiterList = service.findAll();
        callForWaiterList.add(new CallForWaiter(new Tables(table),
                new Timestamp(System.currentTimeMillis())));
    }

    @PostMapping("/acceptCalling")
    @ResponseBody
    public void acceptCalling(@RequestParam int table){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            User user = userService.findByEmail(auth.getName());
            service.mackAsClosed(table, user);
        }
    }
    @PostMapping("/getTable")
    @ResponseBody
    public void getTable(@RequestParam int table){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
           User user = userService.findByEmail(auth.getName());
            orderService.setWaiter(table, user);
        }
    }
    @GetMapping("waiter/orderdetails/{table}")
    public ModelAndView odrerDetails(@PathVariable(value = "table") int table){
        Order order = orderService.findByTable(table);
        ModelAndView modelAndView = new ModelAndView(ViewName.WAITER_ORDERS, "order", order.getOrderedFood());
        int sumOfAllDishPrices = order.getOrderedFood().stream().mapToInt(orderedDish -> orderedDish.getQuantity()*orderedDish.getDish().getPrice()).sum();
        modelAndView.addObject("ordersTotalAmount", sumOfAllDishPrices);
        modelAndView.addObject("user", order.getUser());
        modelAndView.addObject("table", table);
        return modelAndView;

    }
    @GetMapping("waiter/close/{table}")
    public RedirectView closeOrder(@PathVariable(value = "table") int table){
        orderService.closeOrder(table);
        return new RedirectView("/waiter/tab");
    }
    @GetMapping("/waiter/deliver/{id}")
    public RedirectView diliverThis(@PathVariable(value = "id") int id, HttpServletRequest request){
        orderedDishService.setDelivered(id);
        return new RedirectView(request.getHeader("referer"));
    }
}