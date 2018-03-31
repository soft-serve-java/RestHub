package com.kh013j.controllers.admin;

import com.kh013j.controllers.util.ViewName;
import com.kh013j.model.domain.User;
import com.kh013j.model.service.ImgurImageService;
import com.kh013j.model.service.interfaces.RoleService;
import com.kh013j.model.service.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.io.IOException;

@Controller
public class UserAdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ImgurImageService imgurImageService;

    private Logger logger = LoggerFactory.getLogger(UserAdminController.class);

    @GetMapping("/admin/user/all")
    public ModelAndView showReviews(@RequestParam(value = "show", required = false) String showOnly,
                                    @RequestParam(value = "page", required = false) Integer pageNumber){
        ModelAndView modelAndView = new ModelAndView("UsersAdmin");

        if(pageNumber == null || pageNumber < 1) {
            pageNumber = 1;
        }
        if (showOnly == null) {
            showOnly = "all";
        }

        Page<User> usersPage;

        switch (showOnly.toUpperCase()){
            case "CONFIRMED":
                usersPage = userService.findAllEnabledUser(pageNumber, true);
                break;
            case "NOTCONFIRMED":
                usersPage = userService.findAllEnabledUser(pageNumber, false);
                break;
            default:
                usersPage = userService.findAllUser(pageNumber);
        }

        modelAndView.addObject("maxPages", usersPage.getTotalPages());
        modelAndView.addObject("page", pageNumber);
        modelAndView.addObject("showBy", showOnly);
        modelAndView.addObject("Users", usersPage.getContent());
        return modelAndView;
    }

    @GetMapping(value = "admin/user/new")
    public ModelAndView userCreate() {
        return new ModelAndView(ViewName.USER_EDIT_CREATE, "user", new User())
                .addObject("Roles", roleService.findAll());
    }

    @GetMapping(value = "/admin/user/edit/{id}")
    public ModelAndView userEdit(@PathVariable(value = "id") long id) {
        return new ModelAndView(ViewName.USER_EDIT_CREATE, "user",
                userService.findById(id)).addObject("Roles", roleService.findAll());
    }

    @PostMapping(value = "/admin/user/delete/{id}")
    public String userDelete(@PathVariable(value = "id") long id) {
        userService.delete(id);
        return "redirect:/admin/user/all";
    }

    @GetMapping(value = "/admin/user/delete/")
    public String userDeleteNotEnabled() {
        userService.deleteNotEnabledUsers();
        return "redirect:/admin/user/all";
    }

    @PostMapping(value = "/admin/user/save")
    public String userSaveNew(@Valid @ModelAttribute("user") User user,
                              BindingResult userResult,
                              Model model,
                              @RequestParam(value = "pic", required = false) MultipartFile file) {
        if (userResult.hasErrors()) {
            model.addAttribute("Roles", roleService.findAll());
            return ViewName.USER_EDIT_CREATE;
        }
        if (user.getId() == -1) {
            userService.update(user);
        } else {
            User oldUser = userService.findById(user.getId());
            oldUser.setRoles(user.getRoles());
            oldUser.setEmail(user.getEmail());
            user.setPassword(oldUser.getPassword());
            try{
                if(file != null) {
                    oldUser.setAvatar(imgurImageService.uploadImage(file.getBytes()));
                }
            } catch (IOException e) {
                logger.error("Something wrong with file", e, file);
            }
            userService.update(oldUser);
        }
        return "redirect:/admin/user/all";

    }

}
