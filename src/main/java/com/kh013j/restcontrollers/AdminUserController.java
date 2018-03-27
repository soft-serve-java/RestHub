package com.kh013j.restcontrollers;

import com.kh013j.model.domain.User;
import com.kh013j.model.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class AdminUserController {

    private UserService userService;

    @Autowired
    public AdminUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/admin/user/all")
    public List<User> getUser(){
        return userService.findAll();
    }

    @GetMapping("/api/admin/user/{id}")
    public User getUser(@PathVariable("id") long id){
        return userService.findById(id);
    }


    @PostMapping("/api/admin/user/add")
        public User addUser(@RequestBody User user){
            return userService.create(user);
        }

    @DeleteMapping("/api/admin/user/{id}")
    public Boolean deleteUser(@PathVariable("id") long id){
        userService.delete(id);
        return true;
    }
}
