package com.demo.thread;

import java.util.concurrent.TimeUnit;

/**
 * 死锁问题演示
 * 如何排查：jsp -l找到死锁的类ID，jstack Id
 */
public class TestDeadLock2 {
    static class MyThread implements Runnable{
        private String lockA;
        private String lockB;

        public MyThread(String lockA, String lockB){
            this.lockA = lockA;
            this.lockB = lockB;
        }

        @Override
        public void run() {
            synchronized (lockA){
                System.out.println(Thread.currentThread().getName() + "\t自己持有" + lockA + "\t尝试获得" + lockB);
                try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
                synchronized (lockB){
                    System.out.println(Thread.currentThread().getName() + "\t自己持有" + lockB + "\t尝试获得" + lockA);
                }
            }
        }
    }

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new MyThread(lockA, lockB), "Thread A").start();
        new Thread(new MyThread(lockB, lockA), "Thread B").start();
    }
}
