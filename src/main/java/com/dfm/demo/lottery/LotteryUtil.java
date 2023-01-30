package com.dfm.demo.lottery;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:fengming.dai
 */
public class LotteryUtil {
    private  static  String[] gifts = {"再来一次","5$","100$"};

    private static Map<String,Integer> map = new HashMap(3);

    static {
        map.put(gifts[0],0 );
        map.put(gifts[1],0 );
        map.put(gifts[2],0 );
    }

    // time 第几次抽奖 这里从0开始的，需要注意
    private static double[][] probability = {
            {0.4,  0.4,  0.1},
            {0.45, 0.45, 0  },
    };
    public static String init(int time) {
        double randomNumber = Math.random();
        if (randomNumber <= probability[time][0]) {
            plusOne(gifts[0]);
            return gifts[0];
        }
        if (randomNumber <= probability[time][0] + probability[time][1]) {
            plusOne(gifts[1]);
            return gifts[1];
        } else {
            plusOne(gifts[2]);
            return gifts[2];
        }
    }

    private static void plusOne(String name){
        Integer cnt = map.get(name);
        cnt += 1;
        map.put(name,cnt);
    }


    public static void printCount(){
        map.entrySet().forEach(itm->{
            System.out.println(itm.getKey()+": = " + itm.getValue());
        });
    }
}
