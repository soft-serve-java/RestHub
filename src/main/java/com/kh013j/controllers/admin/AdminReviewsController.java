package com.kh013j.controllers.admin;

import com.kh013j.model.service.interfaces.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminReviewsController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/admin/reviews")
    public ModelAndView showReviews(){
        return new ModelAndView("AdminReviews", "reviews", reviewService.findAllDesc());
    }

    @GetMapping("/admin/reviews/{id}/tweak")
    public RedirectView tweakReviewApprove(@PathVariable long id,
                                           @RequestParam boolean approved,
                                           HttpServletRequest request){
        reviewService.tweakApproved(id, approved);
        return new RedirectView(request.getHeader("referer"));
    }
}
