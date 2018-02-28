package com.kh013j.controllers.login;


import com.kh013j.model.domain.User;
import com.kh013j.model.service.interfaces.EmailService;
import com.kh013j.model.service.interfaces.RoleService;
import com.kh013j.model.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;
import java.util.Random;
import java.util.UUID;


@Controller
public class RegisterController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping(value = "/403")
    public String asdv() {
        return "403";
    }

    @GetMapping(value = "/registration")
    public ModelAndView show() {
        return new ModelAndView("registration", "registration", new User());
    }

    // Process form input data
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid User user, BindingResult bindingResult, HttpServletRequest httpServletRequest) {
        User userExists = userService.findByEmail(user.getEmail());
        //System.out.println(userExists);
        modelAndView.addObject("registration", user);
        if (userExists != null) {
            modelAndView.addObject("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided.");
            modelAndView.setViewName("registration");
            bindingResult.reject("email");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else { // new user so we create user and send confirmation e-mail

            Random random = new Random();
            //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword() + String.valueOf(random.nextInt())));
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setRole(roleService.findByName("user"));
            user.setEnabled(false);
            user.setConfirmationtoken(UUID.randomUUID().toString());
            userService.create(user);

            String appUrl = httpServletRequest.getScheme() + "://" + httpServletRequest.getServerName();
            SimpleMailMessage registrationEmail = new SimpleMailMessage();
            registrationEmail.setTo(user.getEmail());
            registrationEmail.setSubject("Registration Confirmation");
            registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
                    + appUrl + ":8080/confirm?token=" + user.getConfirmationtoken());
            registrationEmail.setFrom("noreply@domain.com");
            emailService.sendEmail(registrationEmail);
            modelAndView.setViewName("confirmByEmail");
        }
        return modelAndView;
    }

    // Process confirmation link
    @RequestMapping(value="/confirm", method = RequestMethod.GET)
    public ModelAndView confirmRegistration(ModelAndView modelAndView, @RequestParam Map<String, String> requestParams, @RequestParam("token") String token) {
        User user = userService.findByConfirmationtoken(requestParams.get("token"));
        user.setEnabled(true);
        userService.create(user);
        modelAndView.setViewName("confirmDone");
        return modelAndView;
    }
}