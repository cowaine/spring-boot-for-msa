package com.cowaine.joisfe.part10.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisAdapter {

    @Autowired
    private RedisTemplate redisTemplate;
}
