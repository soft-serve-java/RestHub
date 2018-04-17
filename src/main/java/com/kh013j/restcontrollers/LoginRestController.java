package com.kh013j.restcontrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class LoginRestController {

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
