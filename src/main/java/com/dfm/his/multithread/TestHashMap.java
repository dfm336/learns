package com.dfm.his.multithread;

/**
 * @author dfm
 * @create 2020-09-30 09:52
 */
public class TestHashMap {
    private  static Object resource1 = new Object();
    private  static  Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized(resource1){
                System.out.println(Thread.currentThread()+" get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"waitting  get  resource2");
                synchronized (resource2){
                    System.out.println(Thread.currentThread()+"get resource2");
                }
            }
        }
              ,"线程1"  ).start();

        new Thread(()->{
            synchronized (resource2){
                System.out.println(Thread.currentThread()+"get resource 2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"waitting get resource1");

                synchronized(resource1){
                    System.out.println(Thread.currentThread()+"get resource 1");
                }
            }
        },"线程2").start();



    }
}
