package com.kh013j.restcontrollers;

import com.kh013j.model.domain.Role;
import com.kh013j.model.domain.User;
import com.kh013j.model.service.interfaces.RoleService;
import com.kh013j.model.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/admin/role/")
public class AdminRoleControllerRest {

    private RoleService roleService;

    @Autowired
    public AdminRoleControllerRest(RoleService roleService){
        this.roleService = roleService;
    }

    @GetMapping("/all")
    List<Role> getRole(){
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public Role getRole(@PathVariable("id") long id){
        return roleService.findById(id);
    }

    @PostMapping("/add")
    public Role addRole(@RequestBody Role role){
        return roleService.create(role);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteRole(@PathVariable("id") long id){
        roleService.delete(id);
        return true;
    }
}