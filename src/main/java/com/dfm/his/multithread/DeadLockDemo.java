package com.dfm.his.multithread;

/**
 * @author dfm
 * @create 2020-09-29 09:05
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        DeadLock deadLock1 = new DeadLock();
        DeadLock deadLock2 = new DeadLock();

        deadLock1.flag = 1;

        new Thread(deadLock1).start();
        new Thread(deadLock2).start();
    }
}
