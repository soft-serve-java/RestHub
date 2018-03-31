package com.kh013j.model.service;

import com.kh013j.model.domain.Role;
import com.kh013j.model.domain.User;
import com.kh013j.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet();
/*        for (Role role: user.getRoles()) { amiss comment
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
        }*/
       // grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getName().toUpperCase()));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }
}