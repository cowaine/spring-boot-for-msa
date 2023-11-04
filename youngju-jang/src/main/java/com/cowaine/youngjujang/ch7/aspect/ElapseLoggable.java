package com.cowaine.youngjujang.ch7.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target ({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ElapseLoggable { // pointCut 마킹용 애노테이션
}
