package com.cowaine.coalong.chapter10.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;


/**
 * RedisAutoConfiguration 설정 방법
 * 이 예제에서는 RedisTemplate 스프링 빈을 직접 설정하는 방식을 사용하여 원하는 클래스 타입을 직렬화/역직렬화 한다.
 */
@Component
public class RedisAdapter {
    // Object -> byte[] 직렬화, byte[] -> Object 역직렬화
    @Autowired
    private RedisTemplate redisTemplate;

    // String -> byte[] 직렬화,  byte[] -> String 역직렬화
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
}