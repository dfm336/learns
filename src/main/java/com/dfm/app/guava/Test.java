package com.dfm.app.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;

import java.util.concurrent.TimeUnit;

/**
 * @Author:fengming.dai
 */
public class Test {
    public static void main(String[] args) {
        /**
         *   maximumSize 最大存储元素个数
         *   expireAfterWrite  指定对象，写入缓存之后， 多久过期（写之后）
         *   expireAfterAccess  指定对象，多久没有被访问，多久过期（多久没有被访问成功 ，过期）
         *   removeListener  有记录被删除时，可以感知到这个事件
         */
        Cache<Object, Object> build = CacheBuilder.newBuilder()
                .maximumSize(2) //设置最大存储
                .expireAfterWrite(3, TimeUnit.SECONDS)//指定对象 写入之后  3 秒 过期
                .build(
                        new CacheLoader<Object, Object>() {
                            @Override
                            public Object load(Object o) throws Exception {
                                return null;
                            }
                        }
                );
        build.put("k1","v1");
        System.out.println(build.getIfPresent("k1"));

    }
}
