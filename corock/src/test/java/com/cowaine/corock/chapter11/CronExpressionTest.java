package com.cowaine.corock.chapter11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.scheduling.support.CronExpression;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CronExpressionTest {

    /**
     * <code>cron</code> 속성에 사용할 수 있는 클론 표현식은 다음과 같이 여섯 자리로 표현할 수 있다.
     * <code>@Scheduled(cron = "초 분 시 일 월 요일")</code>
     * <ul>
     *     <li>초: 0 ~ 59 사이의 값</li>
     *     <li>분: 0 ~ 59 사이의 값</li>
     *     <li>시: 0 ~ 23 사이의 값</li>
     *     <li>일: 1 ~ 31 사이의 값</li>
     *     <li>월: 1 ~ 12 또는 JAN ~ DEC 사이의 값</li>
     *     <li>요일: 0 ~ 7 또는 SUN ~ SAT 사이의 값</li>
     * </ul>
     * <p>
     * 이와 별개로 숫자를 대신하여 크론 표현식 문자를 설정할 수 있다. 사용할 수 있는 표현식 문자는 다음과 같다.
     * <ul>
     *     <li>*: 모든 값</li>
     *     <li>?: 어떤 값이든 상관없음</li>
     *     <li>,: 배열 설정 (e.g. 0, 1, 2, 3)</li>
     *     <li>-: 범위 설정 (e.g. 10-20(10에서 20 사이)</li>
     *     <li>/: 초깃값과 증분 값 설정 (e.g. 0/10(초깃값 0, 증분 값 10)</li>
     *     <li>#: 요일과 몇 번째를 설정 (e.g. 5#2(목요일#두 번째)</li>
     *     <li>L: 마지막을 의미</li>
     *     <li>W: 스케줄링된 날부터 가까운 평일 의미</li>
     * </ul>
     * <p>
     * 자리마다 사용할 수 있는 표현식 문자는 다음과 같다.
     * <ul>
     *     <li>초: *, /, ,, -</li>
     *     <li>분: *, /, ,, -</li>
     *     <li>시: *, /, ,, -</li>
     *     <li>일: *, /, ,, -, ?, L, W</li>
     *     <li>달: *, /, ,, -</li>
     *     <li>요일: *, /, ,, -, ?, L, #</li>
     * </ul>
     * <p>
     * 다음 몇 가지 크론 표현식 예제를 살펴보자.
     * <ul>
     *     <li><code>@Scheduled(cron = "* 0/10 * * * ?")</code>: 10분마다 태스크를 스케줄링하여 실행한다.</li>
     *     <li><code>@Scheduled(cron = "0 0 2 * * ?")</code>: 매일 새벽 2시 정각마다 태스크를 스케줄링하어 실행한다.</li>
     *     <li><code>@Scheduled(cron = "0 0 6 * * SUN")</code>: 매주 일요일 오전 6시 정각마다 태스크를 스케줄링하어 실행한다.</li>
     *     <li><code>@Scheduled(cron = "0 0 1,2,3 ? * MON")</code>: 매주 월요일 새벽 1시 00분, 2시 00분, 3시 00분에 태스크를 스케줄링하어 실행한다.</li>
     * </ul>
     */
    @DisplayName("testParse")
    @Test
    void testParse() {
        CronExpression expression = CronExpression.parse("0/5 * * * * ?");
        LocalDateTime nextScheduled = expression.next(LocalDateTime.of(2022, 1, 1, 0, 0, 0));

        assertEquals("2022-01-01T00:00:05", nextScheduled.toString());
        assertEquals("2022-01-01T00:00:10", expression.next(nextScheduled).toString());
    }

}
