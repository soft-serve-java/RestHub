package com.kh013j.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("adminLogin").password("1111").roles("ADMINISTRATOR");
        auth.inMemoryAuthentication().withUser("cookLogin").password("1111").roles("COOK");
        auth.inMemoryAuthentication().withUser("waiterLogin").password("1111").roles("WAITER");
        auth.inMemoryAuthentication().withUser("userLogin").password("1111").roles("USER");
    }



  /*  @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select id, login, password, name, role_id from rh.user where login=?")
                //.authoritiesByUsernameQuery("SELECT \"user\".login, \"user\".password, \"role\".name FROM rh.\"user\", rh.role WHERE \"user\".role_id = \"role\".id and \"user\".login = ?"); //and "user".login = 'adminLogin'
                .authoritiesByUsernameQuery("SELECT \"user\".login, \"role\".name FROM rh.\"user\", rh.role WHERE \"user\".role_id = \"role\".id and \"user\".login = ?");
        ;
    }*/

    //.csrf() is optional, enabled by default, if using WebSecurityConfigurerAdapter constructor
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMINISTRATOR')")
                .antMatchers("/cooker/**").access("hasRole('ROLE_COOK')")
                .antMatchers("/waiter/**").access("hasRole('ROLE_WAITER')")
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