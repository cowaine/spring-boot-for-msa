package com.cowaine.corock;

import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@Slf4j
@SpringBootApplication
public class CorockApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(CorockApplication.class, args);

        Environment env = ctx.getBean(Environment.class);
        String port = env.getProperty("server.port");
        log.info("Customized Port: {}", port);

        String[] beanNames = ctx.getBeanDefinitionNames();
        IntStream.range(0, beanNames.length)
                 .forEach(i -> log.info("Bean Name #{}: {}", i + 1, beanNames[i]));
    }

}
