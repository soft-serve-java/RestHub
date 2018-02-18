package com.kh013j.controllers.login;


import com.kh013j.model.domain.User;
import com.kh013j.model.service.interfaces.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@Controller
public class RegisterController {

    UserService userService;

    @RequestMapping(value = "/403")
    public String asdv() {
        return "403";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView show() {
        return new ModelAndView("registration", "registration", new User());
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String categorySaveNew(@Valid @ModelAttribute("registration") User user, BindingResult userResult, HttpServletResponse response){
        userService.create(user);
        return "redirect:/welcome";
    }



/*    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute(value = "registration") User user, BindingResult result) {
        userService.create(user);
        return "redirect:/welcome";
    }*/

/*    @RequestMapping(value ="/registration" ,method=RequestMethod.POST)
    public ModelAndView registerSuccess(@Valid @ModelAttribute("registration") User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ModelAndView("registration");
        }
        userService.create(user);
        ModelAndView modelAndView = new ModelAndView("welcome");
        modelAndView.addObject("user", user);
        return modelAndView;
    }*/

}