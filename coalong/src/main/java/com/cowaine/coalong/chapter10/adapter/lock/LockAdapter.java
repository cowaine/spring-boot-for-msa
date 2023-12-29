package com.cowaine.coalong.chapter10.adapter.lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@Slf4j
public class LockAdapter {

    // 선착순 이벤트 - 호텔아이디가 키, 사용자 아이디가 밸류
    private final RedisTemplate<LockKey, Long> lockRedisTemplate;
    private final ValueOperations<LockKey, Long> lockOperation;

    public LockAdapter(RedisTemplate<LockKey, Long> lockRedisTemplate) {
        this.lockRedisTemplate = lockRedisTemplate;
        this.lockOperation = lockRedisTemplate.opsForValue();
    }

    // 레디스에 락을 생성하는 메서드, hotelId 를  사용하여 LockKey 객체를 생성하고 레디스 키에 저장한다.
    public Boolean holdLock(Long hotelId, Long userId) {
        LockKey lockKey = LockKey.from(hotelId);
        // setIfAbsent() 메서드는 레디스에 키와 매핑되는 값이 없을 때만 레디스 데이터를 생성한다.
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
