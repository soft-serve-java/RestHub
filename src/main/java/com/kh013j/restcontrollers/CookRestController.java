package com.kh013j.restcontrollers;

import com.kh013j.model.service.interfaces.OrderedDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CookRestController {
    @Autowired
    private OrderedDishService orderedDishService;

    public CookRestController(OrderedDishService orderedDishService) {
        this.orderedDishService = orderedDishService;
    }

  //  @GetMapping("api/cook")
}
