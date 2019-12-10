package com.cisdi.redis.service;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

/**
 * @author pengyangyan
 * @version 1.0.0
 * @date 2019年12月05日 10:55:00
 */
public class GuavaCacheServiceImpl {

    private final static long expire = 3600L;

    Cache<String, Object> loadingCache = CacheBuilder.newBuilder()
                            .maximumSize(10)
                            .expireAfterAccess(expire, TimeUnit.SECONDS)
                            .build(
                                    new CacheLoader<String, Object>() {
                                        @Override
                                        public Object load(String key) throws Exception {
                                            //当缓存中不存在时，进行处理
                                            return null;
                                        }
                                    }
                            );


    public void setLoadingCache(String key,Object object){
        loadingCache.put(key,object);
    }
}
