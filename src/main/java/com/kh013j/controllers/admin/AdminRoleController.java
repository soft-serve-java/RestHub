package com.kh013j.controllers.admin;

import com.kh013j.model.domain.Role;
import com.kh013j.model.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

@Controller
public class AdminRoleController {

    @Autowired
    private RoleService roleService;


    @GetMapping(value = "/admin/role/all")
    public ModelAndView showRole(){
        return new ModelAndView("AdminRole", "role", roleService.findAll() );
    }

    @GetMapping(value = "admin/role/new")
    public ModelAndView createRole(){
        return new ModelAndView("RoleAdd", "role", new Role())
                .addObject("role", new Role());
    }

    @GetMapping(value = "/admin/role/edit/{id}")
    public ModelAndView editCategory(@PathVariable(value = "id") long id) {
        return new ModelAndView("RoleEdit", "role", roleService.findById(id));
    }

    @PostMapping(value = "/admin/role/delete/{id}")
    public String deleteRole(@PathVariable(value = "id") long id) {
        roleService.delete(id);
        return "redirect:/admin/role/all";
    }

    @PostMapping(value = "/admin/role/save")
    public String  saveNewRole(@Valid @ModelAttribute("role") Role role, BindingResult roleResult) {
        roleService.update(role);
        return "redirect:/admin/role/all";
    }
}