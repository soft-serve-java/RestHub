package com.kh013j.controllers.login;


import com.kh013j.model.domain.User;
import com.kh013j.model.service.interfaces.RoleService;
import com.kh013j.model.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class RegisterController {

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping(value = "/403")
    public String asdv() {
        return "403";
    }

    @GetMapping(value = "/registration")
    public ModelAndView show() {
        return new ModelAndView("registration", "registration", new User());
    }

    @PostMapping(value = "/registration")
    public String userSaveNew(@Valid @ModelAttribute("registration") User user, BCryptPasswordEncoder bCryptPasswordEncoder){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(roleService.findByName("user"));
        userService.create(user);
        return "redirect:/welcome";
    }
}