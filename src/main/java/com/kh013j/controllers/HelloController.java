package com.kh013j.controllers;

import com.kh013j.model.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by User on 25.01.2018.
 */
@Controller
public class HelloController {
    @Autowired
    DishRepository repository;
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(){
        return "Hello";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(){
        return "Welcome";
    }

    @RequestMapping(value = "/layoutgrid", method = RequestMethod.GET)
    public String layoutgrid(){
        return "Layoutgrid";
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cart(){
        return "Cart";
    }

    @RequestMapping(value = "/dishdescription", method = RequestMethod.GET)
    public String dishdescription(){
        return "Dishdescription";
    }

}
