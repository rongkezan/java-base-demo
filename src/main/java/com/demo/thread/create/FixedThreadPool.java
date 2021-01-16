package com.demo.thread.create;

import java.util.concurrent.*;

/**
 * 线程创建方式4: 使用线程池创建线程
 *
 * Executors: 线程池工厂类
 * - newCachedThreadPool        创建一个可根据需要创建新线程的线程池
 * - newFixedThreadPool         创建一个可重用固定线程数的线程池
 * - newSingleThreadExecutor    创建一个只有一个线程的线程池
 * - newScheduledThreadPool     创建一个线程池，它可安排给定延迟后运行命令或定期地执行
 */
public class FixedThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 提供指定线程数的线程池
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        // 设置线程池的属性
        executor.setCorePoolSize(15);
        executor.setKeepAliveTime(10, TimeUnit.SECONDS);
        // 执行指定线程的操作，需提供实现Runnable接口或Callable接口实现类的对象
        executor.execute(() -> System.out.println(Thread.currentThread().getName() + "\t 运行了..."));    // 适用于Runnable
        // 适用于Callable
        Future<Integer> submit = executor.submit(() -> 1);  //异步
        System.out.println(submit.get());
        // 关闭连接池
        executor.shutdown();
    }
}
