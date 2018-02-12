package com.kh013j.controllers;

import com.kh013j.controllers.util.ViewName;
import com.kh013j.model.domain.Status;
import com.kh013j.model.service.interfaces.OrderedDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CookerController {
    List<Status> statuses = new ArrayList<>();

    @Autowired
    private OrderedDishService orderedDishService;
    @RequestMapping(value = "/cooker", method = RequestMethod.GET)
    public ModelAndView cooker(){
        return new ModelAndView(ViewName.COOKER,
                "Dishes", orderedDishService.findAllForCooker());
    }
    @RequestMapping(value = "/cooker/gotit/{id}", method = RequestMethod.GET)
    public RedirectView gotIt(@PathVariable(value = "id") long id,
                              HttpServletRequest request){
        orderedDishService.setCooking(id);
        return new RedirectView(request.getHeader("referer"));
    }
    @RequestMapping(value = "/cooker/done/{id}", method = RequestMethod.GET)
    public RedirectView done(@PathVariable(value = "id") long id,
                              HttpServletRequest request){
        orderedDishService.setDone(id);
        return new RedirectView(request.getHeader("referer"));
    }
}
