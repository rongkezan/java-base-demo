package com.demo.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 使用线程池创建线程
 * 思路: 提前创建好多个线程，放入线程池中，使用时直接获取，使用完放回池中。
 * 可以避免频繁创建销毁、实现重复利用。
 *
 * Executors: 线程池工厂类
 * - newCachedThreadPool        创建一个可根据需要创建新线程的线程池
 * - newFixedThreadPool         创建一个可重用固定线程数的线程池
 * - newSingleThreadExecutor    创建一个只有一个线程的线程池
 * - newScheduledThreadPool     创建一个线程池，它可安排给定延迟后运行命令或定期地执行
 */
public class TestThreadPool {
    static class MyThread implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                if (i % 2 == 0){
                    System.out.println(Thread.currentThread().getName() + "\t" + i);
                }
            }
        }
    }

    static class MyThread1 implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                if (i % 2 != 0){
                    System.out.println(Thread.currentThread().getName() + "\t" + i);
                }
            }
        }
    }
    public static void main(String[] args) {
        // 提供指定线程数的线程池
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        // 设置线程池的属性
        executor.setCorePoolSize(15);
        executor.setKeepAliveTime(10, TimeUnit.SECONDS);
        // 执行指定线程的操作，需提供实现Runnable接口或Callable接口实现类的对象
        executor.execute(new MyThread());    // 适用于Runnable
        executor.execute(new MyThread1());
        //service.submit(Callable callable);   // 适用于Callable
        // 关闭连接池
        executor.shutdown();
    }
}
