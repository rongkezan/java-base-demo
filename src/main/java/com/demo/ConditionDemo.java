package com.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程之间按顺序调用，实现 A -> B -> C
 * 三个线程启动，要求如下：
 * A打印5次，B打印10次，C打印15次
 * 接着
 * A打印5次，B打印10次，C打印15次
 * 来10轮
 */
class ShareData02{
    private int num = 1;    // A 1, B 2, C 3
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5(){
        lock.lock();
        try {
            while(num != 1){
                c1.await();
            }
            for(int i = 1; i <= 5; i++){
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            num = 2;
            c2.signal();    //通知第二个
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void print10(){
        lock.lock();
        try {
            while(num != 2){
                c2.await();
            }
            for(int i = 1; i <= 10; i++){
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            num = 3;
            c3.signal();    //通知第三个
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void print15(){
        lock.lock();
        try {
            while(num != 3){
                c3.await();
            }
            for(int i = 1; i <= 15; i++){
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            num = 1;
            c1.signal();    //通知第一个
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ConditionDemo {
    public static void main(String[] args) {
        ShareData02 shareData = new ShareData02();
        new Thread(() -> {
            for(int i = 1; i <= 10; i++){
                shareData.print5();
            }
        }, "A").start();
        new Thread(() -> {
            for(int i = 1; i <= 10; i++){
                shareData.print10();
            }
        }, "B").start();
        new Thread(() -> {
            for(int i = 1; i <= 10; i++){
                shareData.print15();
            }
        }, "C").start();
    }
}
