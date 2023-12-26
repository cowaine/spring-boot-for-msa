package com.cowaine.youngjujang.ch9;

import com.cowaine.youngjujang.ch9.adapter.BillingAdapter;
import com.cowaine.youngjujang.ch9.controller.BillingCodeResponse;
import com.cowaine.youngjujang.ch9.controller.CreateCodeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@Slf4j
@SpringBootApplication
public class JYJApplication {
     public static void main(String[] args) {
          ConfigurableApplicationContext ctxt = SpringApplication.run(JYJApplication.class, args);
          
          BillingAdapter billingAdapter = ctxt.getBean(BillingAdapter.class);
          
          // Get /billing-codes API >> RestTemplate getForEntity() 사용하여 실행하는 예제 (GET + Parameter)
          List<BillingCodeResponse> responses = billingAdapter.getBillingCodes("CODE:1231231");
          log.info("1. Result : {}", responses);//
          
          // Post + body
          CreateCodeResponse createCodeResponse = billingAdapter.create(List.of(1231231L));
          log.info("2. Result : {}", createCodeResponse);
     }
}
