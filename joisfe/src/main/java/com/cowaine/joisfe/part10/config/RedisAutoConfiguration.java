package com.cowaine.joisfe.part10.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

//@Configuration(proxyBeanMethods = false)
//public class RedisAutoConfiguration {
//
//    @Bean
//    @ConditionalOnMissingBean(name = {"redisTemplate"})
//    @ConditionalOnSingleCandidate(RedisConnectionFactory.class)
//    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<Object, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(redisConnectionFactory);
//
//        return template;
//    }
//
//    @Bean
//    @ConditionalOnMissingBean
//    @ConditionalOnSingleCandidate(RedisConnectionFactory.class)
//    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        return new StringRedisTemplate(redisConnectionFactory);
//    }
//}
