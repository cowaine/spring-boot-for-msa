package com.cowaine.coalong.chapter11.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ScheduledTask {

    // 스케줄링 태스크로 1초 간격으로 계속해서 triggerEvent() 메서드가 실행된다.
    // fixedRate() 는 설정된 간격으로 스케줄링 태스크를 실행
    // String 일 때는 fixedRateString
    @Scheduled(fixedRate = 1_000L)
    public void triggerEventByFixedRate() {
        log.info("FixedRate Triggered Event");
    }

    // fixedDelay 에 설정된 시간만큼 태스크와 태스크 사이의 지연 시간을 설정
    // fixedRate 와 fixedDelay 조합으로 많이 사용한다.
    @Scheduled(fixedDelay = 1_000L)
    public void triggerEventByFixedDelay() {
        log.info("FixedDelay Triggered Event");
    }

    // cron 규칙에 맞게 설정된 시간에 스케줄링 테스크르 실행
    @Scheduled(cron = "(cron=\"0 0 1,2,3 ? * MON\")")
    public void triggerEventByCron() {
        log.info("Cron Triggered Event");
    }

}
