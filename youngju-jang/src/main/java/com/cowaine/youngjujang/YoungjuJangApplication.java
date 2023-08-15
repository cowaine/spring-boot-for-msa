package com.cowaine.youngjujang;

import com.cowaine.youngjujang.ch2.domain.DateFormatter;
import com.cowaine.youngjujang.ch2.domain.PriceUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


@Slf4j
@SpringBootApplication
public class YoungjuJangApplication {
    public static void main(String[] args) throws InterruptedException {
        
        ConfigurableApplicationContext ctx = SpringApplication.run(YoungjuJangApplication.class, args);
        
        ThreadPoolTaskExecutor taskExecutor = ctx.getBean(ThreadPoolTaskExecutor.class);
        
        final String dateString = "2020-12-24T23:59:59.-08:00";
//        final String dateString = "2020-12-24T23:59:59";
        
        for(int i=0; i<100; i++){
            // submit 100회 실행
            taskExecutor.submit(()->{
                try{
                    DateFormatter formatter = ctx.getBean("singletonDateFormatter", DateFormatter.class);
                    // 스레드에 안전하다면? 출력되는 값이 모두 동일한 날짜일 것
                    log.info("Date : {}, hashCode : {}", formatter.parse(dateString), formatter.hashCode());
                }catch (Exception e){
                    log.error("error to parse", e);
                }
            });
        }
        TimeUnit.SECONDS.sleep(5);
        ctx.close();
    }
    
    @Bean
    @Scope("prototype")
    public DateFormatter singletonDateFormatter(){
        return new DateFormatter("yyyy-MM-dd'T'HH:mm:ss");
    }
}
