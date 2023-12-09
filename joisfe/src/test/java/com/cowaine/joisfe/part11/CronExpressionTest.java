/*
 * Copyright 2023 NHN (https://nhn.com) and others.
 * © NHN Corp. All rights reserved.
 */

package com.cowaine.joisfe.part11;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.scheduling.support.CronExpression;

public class CronExpressionTest {

    @Test
    public void testParse() {
        CronExpression expression = CronExpression.parse("0/5 * * * * ?");
        LocalDateTime nextScheduled = expression.next(LocalDateTime.of(2022, 1, 1, 0, 0, 0));

        Assertions.assertEquals("2022-01-01T00:00:05", nextScheduled.toString());
        Assertions.assertEquals("2022-01-01T00:00:10", expression.next(nextScheduled).toString());
    }
}
