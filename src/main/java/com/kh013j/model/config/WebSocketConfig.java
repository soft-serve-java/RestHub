package com.kh013j.model.config;

import com.kh013j.controllers.util.CustomHandshakeHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;


//http://spring-projects.ru/guides/messaging-stomp-websocket/
@Configuration
@EnableWebSocketMessageBroker
public class    WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/waiter", "/user");
        config.setApplicationDestinationPrefixes("/app");
        //config.setUserDestinationPrefix("/user");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/call")
                .setAllowedOrigins("*"). withSockJS();
    }

}