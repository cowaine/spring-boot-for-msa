package com.cowaine.corock.chapter10.adaptor.lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Slf4j
@Component
public class LockAdaptor {

    // 선착순 이벤트 - 호텔 아이디가 키, 사용자 아이디가 밸류
    private final RedisTemplate<LockKey, Long> lockRedisTemplate;
    private final ValueOperations<LockKey, Long> lockOperation;

    public LockAdaptor(RedisTemplate<LockKey, Long> lockRedisTemplate) {
        this.lockRedisTemplate = lockRedisTemplate;
        this.lockOperation = lockRedisTemplate.opsForValue();
    }

    public Boolean holdLock(Long hotelId, Long userId) {
        LockKey lockKey = LockKey.from(hotelId);
        return lockOperation.setIfAbsent(lockKey, userId, Duration.ofSeconds(10));
    }

    public Long checkLock(Long hotelId) {
        LockKey lockKey = LockKey.from(hotelId);
        return lockOperation.get(lockKey);
    }

    public void clearLock(Long hotelId) {
        lockRedisTemplate.delete(LockKey.from(hotelId));
    }

}
