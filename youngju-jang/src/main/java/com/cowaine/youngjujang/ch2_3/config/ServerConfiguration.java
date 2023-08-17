package com.cowaine.youngjujang.ch2_3.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan( // @ComponentScan 은 자바 설정클래스에 정의되어야 함. (@Configuration)
     basePackages = {"com.cowaine.youngjujang.ch2_3.config",
          "com.cowaine.youngjujang.ch2_3.domain"},
     basePackageClasses = {ThreadPoolConfig.class, ServerConfig.class}
)
public class ServerConfiguration {
}
