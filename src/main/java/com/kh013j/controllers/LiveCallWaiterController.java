package com.kh013j.controllers;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import com.kh013j.model.domain.CallForWaiter;
import com.kh013j.model.domain.Tables;
import com.kh013j.model.domain.User;
import com.kh013j.model.service.CallForWaiterService;
import com.kh013j.model.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LiveCallWaiterController {

    @Autowired
    private CallForWaiterService service;

    @Autowired
    private OrderService orderService;
    @MessageMapping("/waiterCall")
    @SendTo("waiter/tables")
    public List<Tables> getWaitingTables(@AuthenticationPrincipal User user){
        return orderService.findTableInfoForWaiter(user);
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
    public void acceptCalling(@RequestParam int table, @AuthenticationPrincipal User user){
        service.mackAsClosed(table, user);
    }
}