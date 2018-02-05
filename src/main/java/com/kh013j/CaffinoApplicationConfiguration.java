package com.kh013j;

import com.kh013j.model.service.DishServiceImpl;
import com.kh013j.model.service.OrderServiceImpl;
import com.kh013j.model.service.interfaces.DishService;
import com.kh013j.model.service.interfaces.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaffinoApplicationConfiguration {
  @Bean
  public DishService dishServiceConfig(){
    return new DishServiceImpl();
  }
  @Bean
  public OrderService orderServiceConfig(){
    return new OrderServiceImpl();
  }

}
