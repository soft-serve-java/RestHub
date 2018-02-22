package com.kh013j.controllers.admin;

import com.kh013j.model.domain.Role;
import com.kh013j.model.domain.Status;
import com.kh013j.model.exception.DishNotFound;
import com.kh013j.model.exception.StatusNotFound;
import com.kh013j.model.service.interfaces.RoleService;
import com.kh013j.model.service.interfaces.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class AdminStatusController {
/*
  @Autowired
  private StatusService statusService;


    @RequestMapping(value = "/admin/status/all", method = RequestMethod.GET)
    public ModelAndView showStatus(){
        return new ModelAndView("AdminStatus", "status", statusService.findAll() );
    }

    @RequestMapping(value = "admin/status/new", method = RequestMethod.GET)
    public ModelAndView createStatus(){
        return new ModelAndView("StatusEdit", "status", new Status())
                .addObject("status", new Status());
    }

    @RequestMapping(value = "/admin/status/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editCategory(@PathVariable(value = "id") long id) {

        return new ModelAndView("StatusEdit", "status", statusService.findById(id));
    }


    @RequestMapping(value = "/admin/status/delete/{id}", method = RequestMethod.POST)
    public String deleteStatus(@PathVariable(value = "id") long id) {
        statusService.delete(id);
        return "redirect:/admin/status/all";
    }

    @RequestMapping(value = "/admin/status/save", method = RequestMethod.POST)
    public String  statusNewOrder(@Valid @ModelAttribute("order") Status status, BindingResult orderResult) {
        statusService.update(status);
        return "redirect:/admin/status/all";
    }
    */
}
