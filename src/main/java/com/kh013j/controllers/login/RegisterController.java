package com.kh013j.controllers.login;


import com.kh013j.model.domain.User;
import com.kh013j.model.service.EmailService;
import com.kh013j.model.service.interfaces.RoleService;
import com.kh013j.model.service.interfaces.UserService;
import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;
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

/*  Old working controller
    @PostMapping(value = "/registration")
    public String userSaveNew(@Valid @ModelAttribute("registration") User user, BCryptPasswordEncoder bCryptPasswordEncoder){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(roleService.findByName("user"));
        userService.create(user);
        return "redirect:/welcome";
    }*/


    // Process form input data
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid User user, BindingResult bindingResult, HttpServletRequest httpServletRequest) {

        // Lookup user in database by e-mail
        User userExists = userService.findByEmail(user.getEmail());

        System.out.println(userExists);


        /*if (userExists != null) {
            modelAndView.addObject("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided.");
            modelAndView.setViewName("registration");
            bindingResult.reject("email");
        }*/

        /*if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } */
        //else { // new user so we create user and send confirmation e-mail
        Random random = new Random();

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword() + String.valueOf(random.nextInt())));
        user.setRole(roleService.findByName("user")); // ADD

        // Disable user until they click on confirmation link in email
        user.setEnabled(false);

        // Generate random 36-character string token for confirmation link
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

        //modelAndView.addObject("confirmationMessage", "A confirmation e-mail has been sent to " + user.getEmail());
        modelAndView.setViewName("registration");


        return modelAndView;
}


    // Process confirmation link
    @RequestMapping(value="/confirm", method = RequestMethod.GET)
    public ModelAndView confirmRegistration(ModelAndView modelAndView, @RequestParam("token") String token) {

        User user = userService.findByConfirmationtoken(token);

        if (user == null) { // No token found in DB
            modelAndView.addObject("invalidToken", "Oops!  This is an invalid confirmation link.");
        } else { // Token found
            modelAndView.addObject("confirmationToken", user.getConfirmationtoken());
        }

        modelAndView.setViewName("confirm");
        return modelAndView;
    }

    // Process confirmation link
    @RequestMapping(value="/confirm", method = RequestMethod.POST)
    public ModelAndView confirmRegistration(ModelAndView modelAndView, BindingResult bindingResult, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {

        modelAndView.setViewName("confirm");

        Zxcvbn passwordCheck = new Zxcvbn();

        Strength strength = passwordCheck.measure(requestParams.get("password"));

        if (strength.getScore() < 3) {
            //modelAndView.addObject("errorMessage", "Your password is too weak.  Choose a stronger one.");
            bindingResult.reject("password");

            redir.addFlashAttribute("errorMessage", "Your password is too weak.  Choose a stronger one.");

            modelAndView.setViewName("redirect:confirm?token=" + requestParams.get("token"));
            System.out.println(requestParams.get("token"));
            return modelAndView;
        }

        // Find the user associated with the reset token
        User user = userService.findByConfirmationtoken(requestParams.get("token"));

        // Set new password
        user.setPassword(bCryptPasswordEncoder.encode(requestParams.get("password")));

        // Set user to enabled
        user.setEnabled(true);

        // Save user
        userService.create(user);

        modelAndView.addObject("successMessage", "Your password has been set!");
        return modelAndView;
    }
}