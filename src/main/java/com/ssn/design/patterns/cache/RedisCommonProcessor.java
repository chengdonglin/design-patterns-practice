package com.ssn.design.patterns.cache;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisCommonProcessor {

    private final RedisTemplate redisTemplate;


    public RedisCommonProcessor(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Object get(String key) {
        if (key == null) {
            throw new UnsupportedOperationException("Redis key can not empty");
        }
        return redisTemplate.opsForValue().get(key);
    }

    public void set(String key,Object value) {
        redisTemplate.opsForValue().set(key,value);
    }

    public void set(String key,Object value,long time) {
        if (time > 0) {
            redisTemplate.opsForValue().set(key,value,time, TimeUnit.SECONDS);
        } else {
            set(key,value);
        }
    }
}
