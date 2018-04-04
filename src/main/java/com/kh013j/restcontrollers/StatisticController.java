package com.kh013j.restcontrollers;

import com.kh013j.model.service.interfaces.OrderService;
import com.kh013j.model.service.interfaces.OrderedDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/statistic/")
public class StatisticController {
    @Autowired
    OrderedDishService orderedDishService;
    @Autowired
    OrderService orderService;

    @GetMapping("populars")
    public List<Object[]> getTheMostPopular(){
        //Map<Integer,String> map = orderedDishService.getTheMostPooular();
        return orderedDishService.getTheMostPooular();
    }
    @GetMapping("populars")
    public List<Object[]> orederByMounth(){
        //Map<Integer,String> map = orderedDishService.getTheMostPooular();
        return orderService.orederByMounth();
    }
}
