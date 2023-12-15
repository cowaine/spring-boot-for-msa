package com.cowaine.coalong.chapter11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.scheduling.support.CronExpression;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 크론 표현식을 확인하는 CronExpression 테스트 케이스
 */
class CronExpressionTest {
    @DisplayName("testParse")
    @Test
    void testParse() {
        // parse() 메서드는 크론 표현식을 파싱하여 CronExpression 객체를 생성한다.
        CronExpression expression = CronExpression.parse("0/5 * * * * ?");
        // next() 메서드는 인자로 받은 시간의 다음 스케줄링 시간을 응답한다.
        LocalDateTime nextScheduled = expression.next(LocalDateTime.of(2022, 1, 1, 0, 0, 0));

        assertEquals("2022-01-01T00:00:05", nextScheduled.toString());
        assertEquals("2022-01-01T00:00:10", expression.next(nextScheduled).toString());
    }

}