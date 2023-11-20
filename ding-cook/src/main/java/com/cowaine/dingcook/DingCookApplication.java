package com.cowaine.dingcook;

import com.cowaine.dingcook.chapter09.adpater.BillingAdapter;
import com.cowaine.dingcook.chapter09.controller.BillingCodeResponse;
import com.cowaine.dingcook.chapter09.controller.CreateCodeResponse;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

//@Slf4j
//@SpringBootApplication
public class DingCookApplication {

    public static void main(String[] args) {
//        ConfigurableApplicationContext context = SpringApplication.run(DingCookApplication.class, args);
//        Environment environment = context.getBean(Environment.class);
//        String portValue = environment.getProperty("server.port");
//        log.info("Customized Port:{}", portValue);
//        Arrays.stream(context.getBeanDefinitionNames())
//              .forEach(name -> log.info("Bean Name: {}", name));

        // Chapter09Application 코드 참조
        ConfigurableApplicationContext ctxt = SpringApplication.run(DingCookApplication.class, args);

        BillingAdapter billingAdapter = ctxt.getBean(BillingAdapter.class);

        List<BillingCodeResponse> responses = billingAdapter.getBillingCodes("CODE:1231231");
//        log.info("1. Result : {}", responses);

        CreateCodeResponse createCodeResponse = billingAdapter.create(List.of(1231231L));
//        log.info("2. Result : {}", createCodeResponse);

        CreateCodeResponse codeResponse = billingAdapter.createBillingCode(List.of(9000L, 8000L, 7000L));
//        log.info("3. Result : {}", codeResponse);
    }

}
