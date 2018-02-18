package com.kh013j.controllers;

import com.kh013j.controllers.util.ViewName;
import com.kh013j.model.service.interfaces.OrderedDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CookerController {

    @Autowired
    private OrderedDishService orderedDishService;

    @GetMapping(value = "/cooker")
    public ModelAndView cooker() {
        return new ModelAndView(ViewName.COOKER,
                "Dishes", orderedDishService.findAllForCooker());
    }

    @GetMapping(value = "/cooker/gotit/{id}")
    public RedirectView gotIt(@PathVariable(value = "id") long id,
                              HttpServletRequest request) {
        orderedDishService.setCooking(id);
        return new RedirectView(request.getHeader("referer"));
    }

    @GetMapping(value = "/cooker/done/{id}")
    public RedirectView done(@PathVariable(value = "id") long id,
                             HttpServletRequest request) {
        orderedDishService.setDone(id);
        return new RedirectView(request.getHeader("referer"));
    }
}
