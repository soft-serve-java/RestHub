package com.kh013j.restcontrollers;

import com.kh013j.model.domain.Order;
import com.kh013j.model.domain.Role;
import com.kh013j.model.domain.Status;
import com.kh013j.model.service.interfaces.OrderService;
import com.kh013j.model.service.interfaces.RoleService;
import com.kh013j.model.service.interfaces.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AdminOrderControllerRest {

    private OrderService orderService;
    private RoleService roleService;
    private StatusService statusService;

    @Autowired
    public AdminOrderControllerRest(StatusService statusService, OrderService orderService, RoleService roleService){
        this.orderService = orderService;
        this.roleService = roleService;
        this.statusService = statusService;
    }

    @GetMapping("/api/admin/order/all")
    public List<Order> getOrders(){
        return orderService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("api/admin/order/delete/{id}")
    public boolean deleteOrder(@PathVariable("id") long id){
        orderService.delete(id);
        System.out.println(id);
        return true;
    }

    @PostMapping(value = "api/admin/order/save")
    public String saveNewOrder(@Valid @ModelAttribute("order") Order order, BindingResult orderResult) {
        orderService.update(order);
        return "redirect:/admin/order/all";
    }

    @GetMapping("/api/admin/order/{id}")
    public Order getOrder(@PathVariable("id") long id){
        return orderService.findById(id);
    }

/*    @GetMapping(value = "/api/admin/role/all")
    public List<Role> showRoles(){
        return roleService.findAll();
    }*/

    @GetMapping(value = "/api/admin/status/all")
    public List<Status> showStatuses(){
        return statusService.findAll();
    }

}
