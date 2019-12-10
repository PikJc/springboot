package com.cisdi.redis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @author pengyangyan
 * @version 1.0.0
 * @date 2019年12月03日 10:55:00
 */
@Repository
public class RedisDao {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void setKey(String key,String value){
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set(key,value,1, TimeUnit.MINUTES); //设置一分钟过期
    }

    public String getKey(String key){
        String s = redisTemplate.opsForValue().get(key);
        return s;
    }
}
