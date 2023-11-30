package com.cowaine.coalong.chapter10.adapter;

import com.cowaine.coalong.chapter10.cache.HotelCacheKey;
import com.cowaine.coalong.chapter10.cache.HotelCacheValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@Slf4j
public class CacheAdapter {

    private final RedisTemplate<HotelCacheKey, HotelCacheValue> hotelCacheRedisTemplate;
    private final ValueOperations<HotelCacheKey, HotelCacheValue> hotelCacheOperation;

    // acheAdapter 는 RedisTemplate< HotelCacheKey, HotelCacheValue> hotelCacheRedisTemplate 스프링 빈을 주입받는다.
    public CacheAdapter(RedisTemplate<HotelCacheKey, HotelCacheValue> hotelCacheRedisTemplate) {
        this.hotelCacheRedisTemplate = hotelCacheRedisTemplate;
        // ValueOperations 객체는 키-밸류 자료 구조를 사용할 수 있는 get(), set(), delete() 같은 메서드들을 제공
        this.hotelCacheOperation = hotelCacheRedisTemplate.opsForValue();
    }

    // 레디스에 데이터를 저장할 때 유효 기간을 24시간으로 설정
    public void put(HotelCacheKey key, HotelCacheValue value) {
        hotelCacheOperation.set(key, value, Duration.ofSeconds(24 * 60 * 60));
    }

    public HotelCacheValue get(HotelCacheKey key) {
        return hotelCacheOperation.get(key);
    }

    public void delete(HotelCacheKey key) {
        hotelCacheRedisTemplate.delete(key);
    }
}
