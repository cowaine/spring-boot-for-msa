package com.cowaine.dingcook.chapter06.example;

import org.springframework.stereotype.Component;

@Component
public class GradePropertiesComponent {

    private final GradeProperties gradeProperties;

    public GradePropertiesComponent(GradeProperties gradeProperties) {
        this.gradeProperties = gradeProperties;
        System.out.println(gradeProperties.toString());
    }
}
