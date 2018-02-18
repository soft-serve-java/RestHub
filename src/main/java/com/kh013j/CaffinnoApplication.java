package com.kh013j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@PropertySource(value = "classpath:application.properties")
@PropertySource(value = "file:src/test/resources/application.properties")

@SpringBootApplication
public class CaffinnoApplication {
    public static void main(String[] args) {
         SpringApplication.run(CaffinnoApplication.class, args);
    }
}
