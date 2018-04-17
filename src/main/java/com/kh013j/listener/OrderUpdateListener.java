package com.kh013j.listener;

import com.kh013j.model.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import javax.servlet.annotation.WebListener;
import java.util.Arrays;

public class OrderUpdateListener {
    @Autowired
    private SimpMessagingTemplate template;
    public void onOrderUpdate(Order order){
        template.convertAndSendToUser(Integer.toString(order.getTablenumber()),
                "/oreder-updates", order);
    }
}
