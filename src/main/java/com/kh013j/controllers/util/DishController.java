package com.kh013j.controllers.util;

import com.kh013j.model.domain.Review;
import com.kh013j.model.domain.User;
import com.kh013j.model.exception.DishNotFound;
import com.kh013j.model.service.interfaces.DishService;
import com.kh013j.model.service.interfaces.ReviewService;
import com.kh013j.model.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;

@Controller
public class DishController {

    @Autowired
    private DishService dishService;

    @Autowired
    private UserService userService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping(value = "/dish/{id}")
    public String dishdescription(Model model, @PathVariable(value = "id") long id) {
        model.addAttribute("dish", dishService.findById(id));
        model.addAttribute("populars", dishService.findPopular(id));
        model.addAttribute("reviews", dishService.getComments(dishService.findById(id)));
        return ViewName.DISH_DESCRIPTION;
    }


    @GetMapping(value = "/dish/{id}/addReview")
    public RedirectView addReview(Principal principal,
                                  @PathVariable("id") long dishId,
                                  @RequestParam("review") String comment,
                                  HttpServletRequest request) throws DishNotFound {
        User user = userService.findByEmail(principal.getName());
        Review review = new Review();
        review.setCommentText(comment);
        review.setDish(dishService.findById(dishId));
        review.setUser(user);
        review.setDate(new Timestamp(System.currentTimeMillis()));
        reviewService.create(review);

        return new RedirectView(request.getHeader("referer"));
    }
}
