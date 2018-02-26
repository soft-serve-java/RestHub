package com.kh013j.controllers;

import com.kh013j.controllers.util.ViewName;
import com.kh013j.model.domain.Review;
import com.kh013j.model.domain.User;
import com.kh013j.model.service.interfaces.DishService;
import com.kh013j.model.service.interfaces.ReviewService;
import com.kh013j.model.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.sql.Timestamp;


@Controller
public class DishController {

    @Autowired
    private DishService dishService;

    @Autowired
    private UserService userService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping(value = "/dish/{id}")
    public String dishdescription(Principal principal, Model model,
                                  @PathVariable(value = "id") long id,
                                  @ModelAttribute("newCommentAdded") boolean newCommentAdded) {
        model.addAttribute("canComment", principal != null);
        model.addAttribute("dish", dishService.findById(id));
        model.addAttribute("populars", dishService.findPopular(id));
        model.addAttribute("reviews", dishService.getReviews(dishService.findById(id)));
        model.addAttribute("newCommentAdded", newCommentAdded);
        return ViewName.DISH_DESCRIPTION;
    }


    @GetMapping(value = "/dish/{id}/addReview")
    public RedirectView addReview(Principal principal,
                                  @PathVariable("id") long dishId,
                                  @RequestParam("review") String comment,
                                  RedirectAttributes redirectAttributes) {
        User user = userService.findByEmail(principal.getName());
        Review review = new Review();
        review.setCommentText(comment);
        review.setDish(dishService.findById(dishId));
        review.setUser(user);
        review.setDate(new Timestamp(System.currentTimeMillis()));
        reviewService.create(review);
        redirectAttributes.addFlashAttribute("newCommentAdded", true);
        return new RedirectView("/dish/" + dishId);
    }

    @ModelAttribute("newCommentAdded")
    public boolean getNewCommentAdded() {
        return false;
    }

}
