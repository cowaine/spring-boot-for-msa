package com.cowaine.corock.chapter10.adaptor.cache;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class HotelCacheKeySerializer implements RedisSerializer<HotelCacheKey> {

    public final Charset UTF_8 = StandardCharsets.UTF_8;

    @Override
    public byte[] serialize(HotelCacheKey hotelCacheKey) throws SerializationException {
        if (Objects.isNull(hotelCacheKey)) {
            throw new SerializationException("hotelCacheKey is null");
        }
        return hotelCacheKey.toString().getBytes(UTF_8);
    }

    @Override
    public HotelCacheKey deserialize(byte[] bytes) throws SerializationException {
        if (Objects.isNull(bytes)) {
            throw new SerializationException("bytes is null");
        }
        return HotelCacheKey.fromString(new String(bytes, UTF_8));
    }

}
