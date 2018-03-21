package com.kh013j.restcontrollers;

import com.kh013j.model.domain.OrderedDish;
import com.kh013j.model.domain.Status;
import com.kh013j.model.service.interfaces.OrderedDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class CookRestController {
    @Autowired
    private OrderedDishService orderedDishService;

    public CookRestController(OrderedDishService orderedDishService) {
        this.orderedDishService = orderedDishService;
    }

    @GetMapping("api/cook")
    public List<OrderedDish> getOrderedDishes(){
        return orderedDishService.findAll();
    }

    @GetMapping("api/cook/{orderedDish}")
    public void changeOrderedDishStatus(@PathVariable("orderedDish") OrderedDish orderedDish){
       // in html href point to this method reference
        if(orderedDish.getStatus().getName().equals(Status.COOKING)){
            orderedDishService.setCooking(orderedDish.getId());
        }
        if(orderedDish.getStatus().getName().equals(Status.DONE)){
            orderedDishService.setDone(orderedDish.getId());
        }
    }
}