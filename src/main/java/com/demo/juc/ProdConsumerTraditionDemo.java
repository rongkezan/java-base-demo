package com.demo.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：一个初始值为0的变量，两个线程对其交替操作，一个加1一个减1，来5轮
 * 1. 线程操作资源类
 * 2. 判断 干活 通知
 * 3. 防止虚假唤醒机制: 多线程的调度判断必须用while
 */
public class ProdConsumerTraditionDemo {
    private static class ShareData {
        private int num = 0;
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void increment() {
            for (int i = 1; i <= 5; i++) {
                lock.lock();
                try {
                    while (num != 0) {
                        condition.await();
                    }
                    num++;
                    System.out.println(Thread.currentThread().getName() + "\t" + num);
                    condition.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }

        public void decrement() {
            for (int i = 1; i <= 5; i++) {
                lock.lock();
                try {
                    while (num == 0) {
                        condition.await();
                    }
                    num--;
                    System.out.println(Thread.currentThread().getName() + "\t" + num);
                    condition.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> { shareData.increment(); }, "A").start();
        new Thread(() -> { shareData.decrement(); }, "B").start();
        new Thread(() -> { shareData.increment(); }, "C").start();
        new Thread(() -> { shareData.decrement(); }, "D").start();
    }
}
