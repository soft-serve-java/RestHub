package com.kh013j.listener;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


//@EnableRabbit //нужно для активации обработки аннотаций @RabbitListener
//@Component
public class RabbitMqListener {
    Logger logger = Logger.getLogger(RabbitMqListener.class);

  //  @RabbitListener(queues = "queue1")
    public void processQueue1(String message) {
        logger.info("Received from queue 1: " + message);
    }
}