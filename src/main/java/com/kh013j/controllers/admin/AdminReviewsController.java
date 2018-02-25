package com.kh013j.controllers.admin;

import com.kh013j.model.domain.Review;
import com.kh013j.model.service.interfaces.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public ModelAndView showReviews(@RequestParam(value = "show", required = false) String showOnly,
                                    @RequestParam(value = "page", required = false) Integer pageNumber){
        ModelAndView modelAndView = new ModelAndView("AdminReviews");

        if(pageNumber == null || pageNumber < 1) {
            pageNumber = 1;
        }

        if (showOnly == null) {
            showOnly = "all";
        }

        Page<Review> reviewPage;

        switch (showOnly.toUpperCase()){
            case "NEW":
                reviewPage = reviewService.findAllDescApproved(pageNumber, null);
                break;
            case "APPROVED":
                reviewPage = reviewService.findAllDescApproved(pageNumber, true);
                break;
            case "REJECTED":
                reviewPage = reviewService.findAllDescApproved(pageNumber, false);
                break;
            default:
                reviewPage = reviewService.findAllDesc(pageNumber);
        }

        modelAndView.addObject("reviews", reviewPage.getContent());
        modelAndView.addObject("maxPages", reviewPage.getTotalPages());
        modelAndView.addObject("page", pageNumber);
        modelAndView.addObject("showBy", showOnly);

        return modelAndView;
    }

    @GetMapping("/admin/reviews/{id}/tweak")
    public RedirectView tweakReviewApprove(@PathVariable long id,
                                           @RequestParam boolean approved,
                                           HttpServletRequest request){
        reviewService.tweakApproved(id, approved);
        return new RedirectView(request.getHeader("referer"));
    }
}
