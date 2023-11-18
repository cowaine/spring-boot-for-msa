package com.cowaine.coalong.chapter09;

import com.cowaine.coalong.chapter09.adapter.BillingAdapter;
import com.cowaine.coalong.chapter09.controller.BillingCodeResponse;
import com.cowaine.coalong.chapter09.controller.CreateCodeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@Slf4j
@SpringBootApplication
public class Chapter09WebApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctxt =
                SpringApplication.run(Chapter09WebApplication.class, args);

        BillingAdapter billingAdapter = ctxt.getBean(BillingAdapter.class);

        List<BillingCodeResponse> responses =
                billingAdapter.getBillingCodes("CODE:1231231");
        log.info("1. Result : {}", responses);

        CreateCodeResponse createCodeResponse =
                billingAdapter.create(List.of(1231231L));
        log.info("2. Result : {}", createCodeResponse);

        CreateCodeResponse codeResponse =
                billingAdapter.createBillingCode(List.of(9000L, 8000L, 7000L));
        log.info("3. Result : {}", codeResponse);
    }
}
