package com.cowaine.corock.chapter10.adaptor.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Slf4j
@Component
public class CacheAdaptor {

    private final RedisTemplate<HotelCacheKey, HotelCacheValue> hotelCacheRedisTemplate;
    private final ValueOperations<HotelCacheKey, HotelCacheValue> hotelCacheOperations;

    public CacheAdaptor(RedisTemplate<HotelCacheKey, HotelCacheValue> hotelCacheRedisTemplate) {
        this.hotelCacheRedisTemplate = hotelCacheRedisTemplate;
        this.hotelCacheOperations = hotelCacheRedisTemplate.opsForValue();
    }

    public void put(HotelCacheKey key, HotelCacheValue value) {
        hotelCacheOperations.set(key, value, Duration.ofSeconds(24 * 60 * 60));
    }

    public HotelCacheValue get(HotelCacheKey key) {
        return hotelCacheOperations.get(key);
    }

    public void delete(HotelCacheKey key) {
        hotelCacheRedisTemplate.delete(key);
    }

}
