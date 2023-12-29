package com.cowaine.dingcook.chapter09;

import com.cowaine.dingcook.DingCookApplication;
import com.cowaine.dingcook.chapter09.adpater.BillingAdapter;
import com.cowaine.dingcook.chapter09.controller.BillingCodeResponse;
import com.cowaine.dingcook.chapter09.controller.CreateCodeResponse;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class Chapter09Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctxt = SpringApplication.run(DingCookApplication.class, args);
        BillingAdapter billingAdapter = ctxt.getBean(BillingAdapter.class);

        List<BillingCodeResponse> responses = billingAdapter.getBillingCodes("CODE:1231231");
        log.info("1. Result : {}", responses);

        CreateCodeResponse createCodeResponse = billingAdapter.create(List.of(1231231L));
        log.info("2. Result : {}", createCodeResponse);

        CreateCodeResponse codeResponse = billingAdapter.createBillingCode(List.of(9000L, 8000L, 7000L));
        log.info("3. Result : {}", codeResponse);
    }
}
