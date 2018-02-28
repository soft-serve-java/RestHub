package com.kh013j.controllers.util;

import com.kh013j.model.domain.Role;
import com.kh013j.model.domain.User;
import com.kh013j.model.service.CallForWaiterService;
import com.kh013j.model.service.UserDetailsServiceImpl;
import com.kh013j.model.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableScheduling
public class LiveCallScheduler {
    @Autowired
    private SimpMessagingTemplate template;
    @Autowired
    OrderService service;


   @Scheduled(fixedRate = 1000)
   @Secured({"ROLE_WAITER","RUN_AS_AUDITOR"})
    public void publishUpdates(){
        template.convertAndSend("/waiter/tables", service.findTableInfoForWaiter());
    }
}