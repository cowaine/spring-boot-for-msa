package com.cowaine.dingcook.chapter03.ex02;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class SpringBean02Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBean02Application.class);

        Formatter<LocalDateTime> formatter = context.getBean("localDateTimeFormatter", Formatter.class);
        String date = formatter.of(LocalDateTime.of(2020, 12, 24, 23, 59, 59));

        log.info("Date : " + date);
        context.close();
    }
}
