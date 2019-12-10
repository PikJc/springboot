package com.cisdi.redis.web;

import com.cisdi.redis.dao.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pengyangyan
 * @version 1.0.0
 * @date 2019年12月03日 10:59:00
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    RedisDao redisDao;


    @GetMapping("/set")
    public String setKey(@RequestParam("key") String key, @RequestParam("value")String value){
        redisDao.setKey(key,value);
        return "插入成功";
    }

    @GetMapping("/get")
    public String getKey(String key){
        return redisDao.getKey(key);
    }
}
