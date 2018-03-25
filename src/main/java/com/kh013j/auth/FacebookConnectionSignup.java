package com.kh013j.auth;

import com.kh013j.model.domain.User;
import com.kh013j.model.service.interfaces.RoleService;
import com.kh013j.model.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Service;

import java.util.Collections;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String execute(Connection<?> connection) {
        Facebook facebook = (Facebook) connection.getApi();
        String [] fields = {"name", "email"};
        User user = facebook.fetchObject("me", User.class, fields);
        user.setEnabled(true);
        user.setPassword(bCryptPasswordEncoder.encode(randomAlphabetic(6)));
        user.setConfirmationtoken("FACEBOOK");
        user.setAvatar(connection.getImageUrl());
        user.setRoles(Collections.singleton(roleService.findByName("user")));
        if (userService.findByEmail(user.getEmail()) == null) {
            userService.create(user);
        }
        return user.getEmail();
    }
}
