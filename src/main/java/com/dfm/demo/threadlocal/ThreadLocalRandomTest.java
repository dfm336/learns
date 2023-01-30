package com.dfm.demo.threadlocal;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author:fengming.dai
 */
public class ThreadLocalRandomTest {
    public static void main(String[] args) {
       threadLocalRandomTest();
    }


    public static void threadLocalRandomTest(){
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < 5; i++) {
            //生成 在 【0-5）直接的 随机数
            int r = random.nextInt(5);
            System.out.println(r);
        }
    }

    public static void randomTest(){
        //创建一个 默认随机数生成器，使用 默认种子
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            //生成 在 【0-5）直接的 随机数
            int r = random.nextInt(5);
            System.out.println(r);
        }
    }
}
