package com.cowaine.dingcook.chapter10.adapter.lock;

import java.util.Objects;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class LockKeySerializer implements RedisSerializer<LockKey> {

    @Override
    public byte[] serialize(LockKey lockKey) throws SerializationException {
        if (Objects.isNull(lockKey))
            throw new SerializationException("lockKey is null");

        return lockKey.toString().getBytes();
    }

    @Override
    public LockKey deserialize(byte[] bytes) throws SerializationException {
        if (Objects.isNull(bytes))
            throw new SerializationException("bytes is null");

        return LockKey.fromString(new String(bytes));
    }
}
