package com.kh013j;

import com.kh013j.model.service.DishServiceImpl;
import com.kh013j.model.service.OrderServiceImpl;
import com.kh013j.model.service.RoleServiceImpl;
import com.kh013j.model.service.UserServiceImpl;
import com.kh013j.model.service.interfaces.DishService;
import com.kh013j.model.service.interfaces.OrderService;
import com.kh013j.model.service.interfaces.RoleService;
import com.kh013j.model.service.interfaces.UserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.jdbc.metadata.DataSourcePoolMetadataProvidersConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

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
  @Bean
  public UserService userServiceConfig(){
    return new UserServiceImpl();
  }
  @Bean
  public RoleService roleServiceConfig(){
    return new RoleServiceImpl();
  }
}
