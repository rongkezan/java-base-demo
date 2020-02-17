package com.demo.thread.create;

import java.util.concurrent.*;

/**
 * 自定义一个线程池
 */
public class CustomThreadPool {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(
                2, 5, 1L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        try {
            for (int i = 0; i < 10; i++) {
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
