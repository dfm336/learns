package com.dfm.app.async;

import com.aerospike.client.cluster.ThreadDaemonFactory;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author:fengming.dai
 */
public class TestCompletableFuture {

    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(
            10, 20, 60, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(), new ThreadDaemonFactory());

    static {
        executor.allowCoreThreadTimeOut(true);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        List<CompletableFuture<String>> futures = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                try {
                    Random random = new Random();
                    int sleep = random.nextInt(3000);
                    String ThreadName = Thread.currentThread().getName();
                    System.out.println("ThreadName = " + ThreadName);
                    System.out.println("sleep = " + sleep);
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "future"+ finalI;
            }, executor);
            futures.add(future);
        }

        List<String> res = Lists.newArrayList();
        for (CompletableFuture<String> future : futures) {
            try {
                String s = future.get(2, TimeUnit.SECONDS);
                res.add(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                String s = future.get(2, TimeUnit.SECONDS);
                res.add(s);
                e.printStackTrace();
            }
        }

        res.stream().forEach(System.out::println);

    }
}
