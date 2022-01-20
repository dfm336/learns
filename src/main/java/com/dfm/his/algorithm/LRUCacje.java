package com.dfm.his.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author dfm
 * @create 2020-08-19 12:46
 */
public class LRUCacje<k,v> extends LinkedHashMap<k,v> {

    private final int CHACHE_SIZE;

    /**
     * 传递进来 最多能缓存多少数据
     *
     * @param chacheSize 缓存大小
     */
    public LRUCacje(int chacheSize) {
        //true 表示让 linkedHashMap 按照访问 顺序进行排序  最近访问的放在头部，最老 访问的放在尾部
        super((int) (Math.ceil(chacheSize / 0.75) + 1), 0.75f, true);
        CHACHE_SIZE = chacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<k, v> eldest) {
        //当数据量 > 指定的缓存大小,则清除 最老的数据
        return size() > CHACHE_SIZE;
    }
}

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        LRUCacje<Integer, Integer> lrucache = new LRUCacje<Integer, Integer>(2);
//        for(int i=0;i<n;i++){
//            String operator = in.next();
//            if(operator.equals("PUT")){
//                int x = in.nextInt();
//                int y = in.nextInt();
//                lrucache.put(x,y);
//            }
//            if(operator.equals("GET")){
//                int x = in.nextInt();
//                if(lrucache.containsKey(x)) System.out.println(lrucache.get(x));
//                else System.out.println("-1");
//            }
//        }
//    }
//}
