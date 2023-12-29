package com.cowaine.coalong.chapter10.cache;


import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;
import java.util.Objects;

/**
 * HotelCacheKey 의 RedisSerializer 구현체
 * 레디스 키를 직렬화할 때 문자열로 저장하도록 설계하는 것이 일반적이다.
 * Why?
 * JdkSerialization RedisSerializer 로 직렬화된 데이터는 인코딩된 문자열로 저장된다.
 */
public class HotelCacheKeySerializer implements RedisSerializer<HotelCacheKey> {

    private final Charset UTF_8 = Charset.forName("UTF-8");

    @Override
    public byte[] serialize(HotelCacheKey hotelCacheKey) throws SerializationException {
        if (Objects.isNull(hotelCacheKey))
            throw new SerializationException("hotelCacheKey is null");

        return hotelCacheKey.toString().getBytes(UTF_8);
    }

    @Override
    public HotelCacheKey deserialize(byte[] bytes) throws SerializationException {
        if (Objects.isNull(bytes))
            throw new SerializationException("bytes is null");

        return HotelCacheKey.fromString(new String(bytes, UTF_8));
    }
}
