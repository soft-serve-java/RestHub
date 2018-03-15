package com.kh013j.controllers.util;

import com.kh013j.model.domain.StompPrincipal;
import com.kh013j.model.domain.Tables;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;

public class CustomHandshakeHandler extends DefaultHandshakeHandler {
    // Custom class for storing principal
    @Override
    protected Principal determineUser(ServerHttpRequest request,
                                      WebSocketHandler wsHandler,
                                      Map<String, Object> attributes) {
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest serverRequest = (ServletServerHttpRequest) request;
            return new StompPrincipal(Integer.toString(((Tables)serverRequest.
                    getServletRequest().getSession().getAttribute("tables")).getCurrentTable()));
        }
        throw new UnsupportedOperationException("Not Session");
    }
}
