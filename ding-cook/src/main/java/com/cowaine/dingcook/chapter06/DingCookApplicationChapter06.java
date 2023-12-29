package com.cowaine.dingcook.chapter06;

import com.cowaine.dingcook.chapter06.domain.KafkaProperties;
import com.cowaine.dingcook.chapter06.example.GradeProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackageClasses = {KafkaProperties.class, GradeProperties.class})
public class DingCookApplicationChapter06 {

    public static void main(String[] args) {
        SpringApplication.run(DingCookApplicationChapter06.class, args);
    }
}
