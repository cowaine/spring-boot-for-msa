package com.cowaine.ahngilwoong;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Slf4j
@SpringBootApplication
public class AhngilwoongApplication {

    public static void main(String[] args) {
            SpringApplication.run(AhngilwoongApplication.class, args);

    }

}
