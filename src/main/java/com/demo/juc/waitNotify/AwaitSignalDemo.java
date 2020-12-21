package com.demo.juc.waitNotify;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author keith
 */
public class AwaitSignalDemo {
    static Object objectLock = new Object();
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        new Thread(() ->{
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t" + "come in");
                condition.await();
                System.out.println(Thread.currentThread().getName() + "\t" + "wake up");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "A").start();

        new Thread(() -> {
            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t" + "notify");
            } finally {
                lock.unlock();
            }
        }, "B").start();
    }
}
