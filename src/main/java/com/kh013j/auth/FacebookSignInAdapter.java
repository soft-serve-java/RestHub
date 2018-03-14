package com.kh013j.auth;

import com.kh013j.model.domain.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Arrays;

public class FacebookSignInAdapter implements SignInAdapter {
    @Override
    public String signIn(String localUserId, Connection<?> connection, NativeWebRequest request) {
        Facebook facebook = (Facebook) connection.getApi();
        String [] fields = {"email"};
        User user = facebook.fetchObject("me", User.class, fields);

        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(), null,
                        Arrays.asList(new SimpleGrantedAuthority("user"))));
        return null;
    }
}
