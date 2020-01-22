package com.demo.thread;

/**
 * 线程优先级
 *
 * 线程的优先级等级
 *  MIN_PRIORITY = 1
 *  NORM_PRIORITY = 5
 *  MAX_PRIORITY = 10
 * 涉及的方法
 *  getPriority()                   返回线程优先值
 *  setPriority(int newPriority)    改变线程的优先级
 */
public class TestThreadPriority {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
                System.out.println(Thread.currentThread().getName() + "\t" + Thread.currentThread().getPriority());
            }
        }, "t1").start();
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.currentThread().getPriority());
    }
}
