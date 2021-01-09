package com.demo.juc.lock;

/**
 * 如果两个方法共用同一把锁，那么执行第一个加锁方法的时候，第二个加锁方法也会被锁
 */
public class OneLockDemo {

    private static synchronized void m1() {
        try {
            System.out.println("move in m1");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static synchronized void m2() {
        System.out.println("move in m2");
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(OneLockDemo::m1, "A").start();
        Thread.sleep(1000);
        new Thread(OneLockDemo::m2, "B").start();
    }
}
