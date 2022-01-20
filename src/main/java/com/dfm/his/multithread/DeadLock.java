package com.dfm.his.multithread;

/**
 * @author dfm
 * @create 2020-09-29 09:07
 */
public class DeadLock implements Runnable {
    private static Object object1 = new Object();
    private static  Object object2  = new Object();
    public int flag = 0;

    @Override
    public void run() {
        if(flag == 0){
            synchronized (object1){
                System.out.println("flag  :"+flag+"  own object1");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("申请 object2");
                synchronized(object2){
                    System.out.println("flag  :"+flag+"  own object2");
                }
            }
        }
        if(flag == 1){
            synchronized (object2){
                System.out.println("flag  :"+flag+"  own object2");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("申请 object1");
                synchronized(object1){
                    System.out.println("flag  :"+flag+"  own object1");
                }
            }
        }
    }
}
