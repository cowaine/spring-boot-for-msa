package com.cowaine.ahngilwoong;

import com.cowaine.ahngilwoong.chapter9.adapter.WebClientBillingAdapter;
import com.cowaine.ahngilwoong.chapter9.model.CreateCodeResponse;
import java.util.List;
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
        ConfigurableApplicationContext ctxt = SpringApplication.run(AhngilwoongApplication.class, args);

    }

}
