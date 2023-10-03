package com.cowaine.coalong.chapter03;

import com.cowaine.coalong.chapter03.service.CircularService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CircularApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctxt = SpringApplication.run(CircularApplication.class);
        CircularService circularService = ctxt.getBean(CircularService.class);
        ctxt.close();
    }
}