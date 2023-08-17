package com.cowaine.youngjujang.ch2_3.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value={ThreadPoolConfig.class, MailConfig.class})
public class ServerConfig {
     // 119p
     /*
     * @Import : @ComponentScan과 비슷함.
     * @ComponentScan : 패키지 경로를 스캔
     * @Import : 대상 자바 설정 클래스들을 명시적으로 지정 > 더 직관적
     * @SprintBootApplication에 이미 ComponentScan 정의되어 있어, 굳이 Import 안씀
     * */
}
