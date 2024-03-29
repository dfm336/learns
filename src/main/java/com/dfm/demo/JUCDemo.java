package com.dfm.demo;

import org.luaj.vm2.ast.Str;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author:fengming.dai
 */
public class JUCDemo {
    public static void main(String[] args) {
        testAtomic();
    }





    public static void testCopyOnWriteList(){
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("s");
        copyOnWriteArrayList.remove("s");
        new CopyOnWriteArraySet();

    }

    public static void testAtomic(){
        AtomicLong  atomicLong = new AtomicLong(0);
        long get = atomicLong.get();
        System.out.println("get = " + get);
        System.out.println("atomicLong = " + atomicLong);

        long andIncrement = atomicLong.getAndIncrement();
        System.out.println("andIncrement = " + andIncrement);
        System.out.println("atomicLong = " + atomicLong);

        long andDecrement = atomicLong.getAndDecrement();
        System.out.println("andDecrement = " + andDecrement);
        System.out.println("atomicLong = " + atomicLong);


        LongAdder longAdder = new LongAdder();
        longAdder.sum();


    }

    public static void testDaemonThread(){
        Thread thread = new Thread(() -> {
            while (true) {
            }
        });
        thread.start();
        System.out.println("main thread over");
    }

    public static void testThread() throws InterruptedException {
        Thread threadOne = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread one over!");
        });


        Thread threadTwo = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread two over!");
        });

        threadOne.start();
        threadTwo.start();

        System.out.println("main Thread was blocked~~~  wait child thread finish");

        threadOne.join();
        threadTwo.join();

        System.out.println("main Thread  finish");
    }



    public static void testLockSupport(){
        System.out.println("begin park");
        LockSupport.park();
        System.out.println("end park");
    }


}
