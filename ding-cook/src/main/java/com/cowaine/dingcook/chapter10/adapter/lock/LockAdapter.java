package com.cowaine.dingcook.chapter10.adapter.lock;

import java.time.Duration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@Slf4j
@RequiredArgsConstructor
public class LockAdapter {

    private final RedisTemplate<LockKey, Long> lockRedisTemplate;
    private final ValueOperations<LockKey, Long> lockOperation;

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
