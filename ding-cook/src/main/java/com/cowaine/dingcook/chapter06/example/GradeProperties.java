package com.cowaine.dingcook.chapter06.example;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "grades")
public class GradeProperties {

    private List<Grade> grades;

    @ToString
    @Getter
    @Setter
    public static class Grade {
        private String subject;
        private Integer score;
    }
}
