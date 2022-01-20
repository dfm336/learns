package com.dfm.his.algorithm.sort;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author dfm
 * @create 2020-10-26 17:18
 */
public class LRUCache  extends LinkedHashMap {
    int capitcy;

    public LRUCache(int capitcy){
        super((int) Math.ceil(capitcy/0.75+1),0.75f,true);
        capitcy = capitcy;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size()>capitcy;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put(1,2);
        lruCache.put(3,3);
        lruCache.get(3);
        lruCache.put(4,4);

        Set set = lruCache.keySet();
        set.forEach(x-> System.out.println(lruCache.get(x)));



    }
}
