package com.cowaine.corock.chapter11.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ScheduledTask {

    /**
     * 스케줄링 태스크로 1초 간격으로 계속해서 {@link ScheduledTask#triggerEvent()} 메서드가 실행된다.
     * {@link Scheduled#fixedRate()} 는 설정된 간격으로 스케줄링 태스크를 실행한다.
     * 이외에도 실행 주기를 설정하는 속성은 {@link Scheduled#cron()} 과 {@link Scheduled#fixedDelay()} 가 있다.
     * <p>
     * {@link Scheduled} 애너테이션을 사용하는 규칙은 다음과 같다.
     *
     * <ul>
     *     <li>스케줄 태스크를 정상적으로 실행하려면 스프링 빈의 메서드에 정의해야 한다.</li>
     *     <li>정의된 메서드의 반환 타입은 <code>void</code> 이며, 인자를 정의하면 안 된다. 또한 해당 메서드의 접근 지정자는 <code>public</code> 이어야 한다.</li>
     * </ul>
     */
    @Scheduled(fixedRate = 1_000L)
    public void triggerEvent() {
        log.info("Triggered Event");
    }

}
