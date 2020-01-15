package com.demo.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 *  线程可以进入任何一个它已经拥有的锁所同步的代码块
 */
public class ReenterLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(() -> {
            try {
                phone.sendSms();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();
        new Thread(() -> {
            try {
                phone.sendSms();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("====================================");

        Thread t3 = new Thread(phone);
        Thread t4 = new Thread(phone);

        t3.start();
        t4.start();
    }

    private static class Phone implements Runnable{
        // synchronized 是可重入锁
        public synchronized void sendSms() throws Exception{
            System.out.println(Thread.currentThread().getName() + "\t invoked sendSms");
            sendEmail();
        }
        public synchronized void sendEmail() throws Exception{
            System.out.println(Thread.currentThread().getName() + "\t invoked sendEmail");
        }

        // ReentrantLock 也是可重入锁
        Lock lock = new ReentrantLock();
        @Override
        public void run() {
            get();
        }

        public void get(){
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName() + "\t invoked get");
                set();
            } finally {
                lock.unlock();
            }
        }

        public void set(){
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName() + "\t invoked set");
            } finally {
                lock.unlock();
            }
        }
    }
}
