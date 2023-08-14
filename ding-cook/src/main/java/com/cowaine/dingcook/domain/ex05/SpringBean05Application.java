package com.cowaine.dingcook.domain.ex05;

import java.text.ParseException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@Slf4j
@SpringBootApplication
public class SpringBean05Application {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBean05Application.class, args);

        ThreadPoolExecutor taskExecutor = applicationContext.getBean(ThreadPoolExecutor.class);

        final String dateString = "2020-12-24T23:59:59.-08:00";

        for (int i = 0; i < 100; i++) {
            taskExecutor.submit(() -> {
                DateFormatter formatter = applicationContext.getBean("singletonDateFormatter",
                    DateFormatter.class);

                try {
                    log.info("Date: {}, hashCode: {}", formatter.parse(dateString), formatter.hashCode());
                } catch (ParseException e) {
                    log.error("error to parse", e);
                }
            });
        }

        TimeUnit.SECONDS.sleep(5);
        applicationContext.close();
    }

    @Bean
    @Scope("prototype")
    public DateFormatter singletonDateFormatter() {
        return new DateFormatter("yyyy-MM-dd'T'HH:mm:ss");
    }
}
