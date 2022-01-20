package com.dfm.app.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author:fengming.dai
 */
public class Test1 {
    public static void main(String[] args) {
        LoadingCache<String, Object> build = CacheBuilder.newBuilder()
                .maximumSize(3)
                .refreshAfterWrite(3000, TimeUnit.SECONDS)
                .build(
                        new CacheLoader<String, Object>() {
                            @Override
                            public Object load(String key) throws Exception {
                                Thread.sleep(1000);
                                System.out.println(key+" have loaded from cacheLoader ");
                                return key+"'s value";
                            }
                        }
                );
        build.put("k1","v1");
        try {
            System.out.println("build.get(\"k1\") = " + build.get("k1"));
            System.out.println(build.get("k2"));
            System.out.println(build.get("k3"));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
