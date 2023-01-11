package com.dfm.demo;

/**
 * @Author:fengming.dai
 */
public class JUCDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
            }
        });
        thread.start();
        System.out.println("main thread over");
    }
//    public static void main(String[] args) throws InterruptedException {
//        Thread threadOne = new Thread(() -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Thread one over!");
//        });
//
//
//        Thread threadTwo = new Thread(() -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Thread two over!");
//        });
//
//        threadOne.start();
//        threadTwo.start();
//
//        System.out.println("main Thread was blocked~~~  wait child thread finish");
//
//        threadOne.join();
//        threadTwo.join();
//
//        System.out.println("main Thread  finish");
//
//    }
}
