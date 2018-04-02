package com.kh013j.restcontrollers;

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

    @GetMapping("populars")
    public List<Object[]> getTheMostPopular(){
        //Map<Integer,String> map = orderedDishService.getTheMostPooular();
        return orderedDishService.getTheMostPooular();
    }
    /*SELECT COUNT (rh.orderdish.id), orderdish.quantity, rh.dish.name FROM rh.orderdish INNER JOIN rh.dish ON orderdish.dish_id = rh.dish.id WHERE
  rh.orderdish.order_id IN
  (SELECT rh."order".id FROM rh."order" WHERE EXTRACT(ISOYEAR FROM "order".time )
  = EXTRACT(ISOYEAR FROM now()) AND EXTRACT(WEEK FROM "order".time) = EXTRACT(WEEK FROM NOW())) GROUP BY name, quantity;
*/
}
