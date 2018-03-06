package com.kh013j.controllers;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

public class RabbitMQWaiterController {
    private Logger logger = Logger.getLogger(RabbitMQWaiterController.class.getName());

    @Autowired
    private AmqpTemplate template;

    @RequestMapping("/emit")
    @ResponseBody
    String queue1() {
        logger.info("Emit to queue1");
        template.convertAndSend("queue1","Message to queue");
        return "Emit to queue";
    }
}
