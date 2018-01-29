package com.kh013j.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by User on 25.01.2018.
 */
@Controller
public class HelloController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(){
        return "Hello";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(){
        return "Welcome";
    }
    @RequestMapping(value = "/layoutgrid", method = RequestMethod.GET)
    public String Layoutgrid(){
        return "Layoutgrid";
    }

}
