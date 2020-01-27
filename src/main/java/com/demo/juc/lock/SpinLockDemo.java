package com.demo.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 实现一个自旋锁
 * 循环比较直到获取成功为止，没有类似wait的阻塞
 * 流程: A线程进入发现锁是null，持有锁。B线程进入发现锁不为空，等待。当A解锁后，B再持有锁。
 */
public class SpinLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "\t进入");
        // 期望值为null，真实值为null，才加锁
        while(!atomicReference.compareAndSet(null, thread)){

        }
    }

    public void myUnLock(){
        Thread thread = Thread.currentThread();
        // 期望值为当前线程，真实值为当前线程，才解锁
        atomicReference.compareAndSet(thread, null);
        System.out.println(thread.getName() + "\t调用unLock");
    }

    public static void main(String[] args) throws InterruptedException {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.myLock();
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
            spinLockDemo.myUnLock();
        }, "A").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            spinLockDemo.myLock();
            spinLockDemo.myUnLock();
        }, "B").start();
    }
}
