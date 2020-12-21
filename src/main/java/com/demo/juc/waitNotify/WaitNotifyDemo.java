package com.demo.juc.waitNotify;

/**
 * Object wait notify
 * 1. 必须在同步代码块中才会生效
 * 2. 先notify后wait后线程会一直等待
 *
 * @author keith
 */
public class WaitNotifyDemo {
    static Object objectLock = new Object();

    public static void main(String[] args) {
        new Thread(() ->{
            synchronized (objectLock){
                System.out.println(Thread.currentThread().getName() + "\t" + "come in");
                try { objectLock.wait(); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName() + "\t" + "wake up");
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (objectLock){
                objectLock.notify();
                System.out.println(Thread.currentThread().getName() + "\t" + "notify");
            }
        }, "B").start();
    }
}
