package com.kh013j.controllers.util;

import com.kh013j.model.service.CallForWaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class LiveCallScheduler {
    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    CallForWaiterService service;

    @Scheduled(fixedRate = 5000)
    public void publishUpdates(){
        template.convertAndSend("/waiter/tables", service.findAll());
    }

}
