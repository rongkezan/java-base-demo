package com.demo.thread;

import lombok.SneakyThrows;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题之Lock锁 --- Jdk5.0
 * 面试题1: synchronized 和 lock 的异同？
 * synchronized机制在执行完相应的同步代码后，自动地释放同步监视器
 * lock需要手动地启动同步和结束同步
 *
 * 面试题2: 如果解决线程安全问题，有几种方法？
 * 3种，lock 和 synchronized(同步方法和同步代码块)
 */
public class TestLock {
    static class Window implements Runnable {
        private int ticket = 100;

        private Lock lock = new ReentrantLock();

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    if(ticket > 0){
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().getName() + "售票，票号为:\t" + ticket);
                        ticket --;
                    } else{
                        break;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        Window window = new Window();
        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        Thread t3 = new Thread(window);
        t1.start();
        t2.start();
        t3.start();
    }
}
