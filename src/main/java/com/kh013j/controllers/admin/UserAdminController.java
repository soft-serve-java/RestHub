package com.kh013j.controllers.admin;

import com.kh013j.controllers.util.ViewName;
import com.kh013j.model.domain.User;
import com.kh013j.model.service.interfaces.RoleService;
import com.kh013j.model.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserAdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/admin/user/all")
    public ModelAndView showUsers() {
        return new ModelAndView(ViewName.SHOW_USERS, "Users", userService.findAll());
    }

    @GetMapping(value = "admin/user/new")
    public ModelAndView userCreate() {
        return new ModelAndView(ViewName.USER_EDIT_CREATE, "user", new User())
                .addObject("Roles", roleService.findAll());
    }

    @GetMapping(value = "/admin/user/edit/{id}")
    public ModelAndView userEdit(@PathVariable(value = "id") long id) {
        return new ModelAndView(ViewName.USER_EDIT_CREATE, "user",
                userService.findById(id)).addObject("Roles", roleService.findAll());
    }

    @PostMapping(value = "/admin/user/delete/{id}")
    public String userDelete(@PathVariable(value = "id") long id) {
        userService.delete(id);
        return "redirect:/admin/user/all";
    }

    @PostMapping(value = "/admin/user/save")
    public String userSaveNew(@Valid @ModelAttribute("user") User user, BindingResult userResult,
                              Model model) {
        if (userResult.hasErrors()) {
            model.addAttribute("Roles", roleService.findAll());
            return ViewName.USER_EDIT_CREATE;
        }
        userService.update(user);
        return "redirect:/admin/user/all";

    }
}
