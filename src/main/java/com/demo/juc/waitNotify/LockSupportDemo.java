package com.demo.juc.waitNotify;

import java.util.concurrent.locks.LockSupport;

/**
 * 通知可以在阻塞之前执行，先通知后阻塞失效
 * @author keith
 */
public class LockSupportDemo {
    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "come in");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t" + "wake up");
        }, "A");
        a.start();

        new Thread(() -> {
            LockSupport.unpark(a);
            System.out.println(Thread.currentThread().getName() + "\t" + "notify");
        }, "B").start();
    }
}
