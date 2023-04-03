package com.dfm.app;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Exam {
    public static void main(String[] args) {
//        divide();
        test();
    }

    //编程：篮子里有100个苹果，将这些苹果进行编号，从0开始到99，
    // 现在将这些苹果分成4份，第一份21个，第二份30个，第三份38个，最后一份11个，要求是苹果的编号不能连续。
    //     要求：a. 算法思路明确清晰 b. 结果正确
    //
    public static  void divide(){
//        int[] apples = new int[100];
        int[] num1 = new int[38];
        int[] num2 = new int[30];
        int[] num3 = new int[21];
        int[] num4 = new int[11];
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;

        int stander = 4;
        //最后八个 会分到 同一组，特殊放入
        for (int i = 0; i < 92; i++) {
            int index = i % stander;
            if ( index == 0){
                num1[count1++] = i;
//                if ( count3 == 30){
//                    stander--;
//                }
            }else if ( index == 1){
                num2[count2++] = i;
                if ( count3 == 30){
                    stander--;
                }
            }else if ( index == 2 ){
                num3[count3++] = i;
                if ( count3 == 21){
                    stander--;
                }
            } else {
                num4[count4++] = i;
                if ( count4 == 11){
                    stander--;
                }
            }
        }
        System.out.println("count1 = " + count1);
        int[] end = {94,92,95,99,97,96,93,98};
        for (int i = 0; i < end.length; i++) {
            num1[count1++] = end[i];
        }

        System.out.println("num1 :");
        Arrays.stream(num1).forEach(itm->System.out.print(itm+" "));
        System.out.println();

        System.out.println("num2 :");
        Arrays.stream(num2).forEach(itm->System.out.print(itm+" "));
        System.out.println();


        System.out.println("num3 :");
        Arrays.stream(num3).forEach(itm->System.out.print(itm+" "));
        System.out.println();

        System.out.println("num4 :");
        Arrays.stream(num4).forEach(itm->System.out.print(itm+" "));

    }

    ////评测题目:

    //编程：实现一个生产者消费者模式（自己实现，不要使用JDK自带的阻塞队列），
    //    要求：a. 多个生产者、一个消费者，在保证逻辑正确的前提下，尽可能提高生产和消费的性能。
    //    b. 代码清晰、逻辑完整
    //    c. 线程安全

    public static volatile LinkedList<String> list = new LinkedList<>();

    public static ReentrantLock lock = new ReentrantLock();

    public static volatile boolean needConsume = false;

    public static void provide(String data){
        lock.lock();
        try {
            list.addFirst(data);
            needConsume = true;
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            System.out.println("produce data : "+ data);
        }finally {
            lock.unlock();
        }

    }

    public static String consumer(){
        lock.lock();
        try {
            while ( needConsume ){
                String poll = list.poll();
                System.out.println("consumer data :"+ poll);
                return poll;
            }
        }finally {
            lock.unlock();
        }
        return "";
    }

    public static void test(){
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Thread provider = new Thread(() -> {
            String data = "gen_data" + atomicInteger.getAndIncrement();
            provide(data);
        });
        Thread provider2 = new Thread(() -> {
            String data = "gen_data" + atomicInteger.getAndIncrement();
            provide(data);
        });
        Thread provider3 = new Thread(() -> {
            String data = "gen_data" + atomicInteger.getAndIncrement();
            provide(data);
        });

        Thread consumer = new Thread(() -> {
            while (true){
                consumer();
            }
        });

        provider.start();
        provider2.start();
        provider3.start();

        consumer.start();


    }

}
