package com.demo.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author keith
 */
public class LockSupportDemo {
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
                try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName() + "\t" + "wake up");
            }
        }, "B").start();
    }
}
