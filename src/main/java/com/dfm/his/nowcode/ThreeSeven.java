package com.dfm.his.nowcode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dfm
 * @create 2020-09-29 09:24
 */
public class ThreeSeven {

    /**
     * SQL优化，SECECT * FROM account LIMIT ?,? 这个分页查询随着offset增大，查询变得缓慢，如果是你怎么优化
     * 1. select a.a,a.b,a.c..... from acount a where a.id>=(select id from account limit ?,1)limit ?;
     * 利用覆盖索引 覆盖主键索引(即只需扫描索引而无须回表）
     * 2. select a.a,a.b,a.c...from account a Join (select id  from account limit ?,?) b on a.id = b.id;
     * 4、无排序数组含3.7亿个元素(含有负数)，给定另外一个数组exists，要求判断exists中的每个元素是否在无排序数组中
     * @param unsortarrays
     * @param existcheckarrays
     * @return
     */
    public static boolean[] method(Integer[] unsortarrays,Integer[] existcheckarrays){
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(unsortarrays));
        boolean[] charge = new boolean[existcheckarrays.length];
        int index = 0;
        AtomicInteger acIndex = new AtomicInteger();
        Arrays.asList(existcheckarrays).stream()
                .filter(x->charge[acIndex.getAndIncrement()] = set.contains(x) ? true : false);//符合的留下
        return charge;
    }
}
