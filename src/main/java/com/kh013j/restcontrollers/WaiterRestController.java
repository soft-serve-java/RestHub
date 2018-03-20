package com.kh013j.restcontrollers;

import com.kh013j.controllers.OrderController;
import com.kh013j.model.domain.Tables;
import com.kh013j.model.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class WaiterRestController {
    @Autowired
    OrderService orderService;

    @GetMapping("api/tableStatus")
    public List<Tables> getTableInfoForWaiter(){
        return orderService.findTableInfoForWaiter();
    }

    @GetMapping("api/tableQuantity")
    public int getTableQuantity(){
        return new Tables().getQuantityOfTables();
    }
}
