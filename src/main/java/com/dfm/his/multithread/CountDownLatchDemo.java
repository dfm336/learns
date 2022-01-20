package com.dfm.his.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author dfm
 * @create 2020-11-26 16:08
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        String[] techers = new String[]{"语文老师","英语老师","数学老师","物理老师","化学老师","生物老师"};

        //创建6个线程，模拟 6个老师
        List<Thread> threads = new ArrayList<>(6);

        Random random = new Random();
//        System.out.println(random.nextInt(100));

        for(int i=0;i<6;i++){
            threads.add(new Thread( ()->{

                try {
                    int workTime = random.nextInt(6)+1;
                    Thread.sleep(workTime * 1001);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"阅卷完成");
                //模拟 老师 阅完卷 后，计数器 -1
                countDownLatch.countDown();

            },techers[i]));

        }

        for(Thread thread: threads){
            thread.start();
        }

        //让主线程 等待 所有老师 阅卷完成
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("所有老师 已经阅卷完毕！！");
        System.out.println("开始 计算 总成绩，然后排名");
    }
}
