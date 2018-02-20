package com.kh013j.configuration;

import com.kh013j.model.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;


import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

/*    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("adminLogin").password("1111").roles("ADMINISTRATOR");
        auth.inMemoryAuthentication().withUser("cookLogin").password("1111").roles("COOK");
        auth.inMemoryAuthentication().withUser("waiterLogin").password("1111").roles("WAITER");
        auth.inMemoryAuthentication().withUser("userLogin").password("1111").roles("USER");
    }*/

    @Bean(name="passwordEncoder")
    public PasswordEncoder passwordencoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserDetailsService userService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").access("hasAuthority('ADMINISTRATOR')")
                .antMatchers("/cooker/**").access("hasAuthority('COOK')")
                .antMatchers("/waiter/**").access("hasAuthority('WAITER')")
                //.antMatchers("/user/**").hasAnyRole("USER")

                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout")
                .and()
                .csrf()
                .and()
                //.exceptionHandling().accessDeniedHandler(accessDeniedHandler)
                .exceptionHandling().accessDeniedPage("/403");
    }
}