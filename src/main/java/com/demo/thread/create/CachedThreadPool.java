package com.demo.thread.create;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) {
//        ExecutorService pool = Executors.newFixedThreadPool(5);   //一池5个线程，执行长期任务，性能好很多
//        ExecutorService pool = Executors.newSingleThreadExecutor();   //一池1个线程，一个任务一个任务执行的场景
        ExecutorService pool = Executors.newCachedThreadPool(); //一池N个线程，执行多短期异步的小程序或者负载比较轻的服务
        try {
            // 模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程
            for (int i = 1; i <= 30; i++) {
                final int fi = i;
                pool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t" + fi);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }
}
