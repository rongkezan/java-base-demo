package com.demo.juc;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier
 *  先到的被阻塞，直到到达指定值时释放
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> System.out.println("释放通行"));
        for(int i = 1; i <= 7; i++){
            final int tempInt = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 线程已到");
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
