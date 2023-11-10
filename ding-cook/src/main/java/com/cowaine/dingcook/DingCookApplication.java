package com.cowaine.dingcook;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@Slf4j
@SpringBootApplication
public class DingCookApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DingCookApplication.class, args);

//        Environment environment = context.getBean(Environment.class);
//        String portValue = environment.getProperty("server.port");
//        log.info("Customized Port:{}", portValue);
//
//        Arrays.stream(context.getBeanDefinitionNames())
//              .forEach(name -> log.info("Bean Name: {}", name));
    }

}
