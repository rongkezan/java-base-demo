package com.demo;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 共计9个桔子，有3个小朋友
 * 小朋友A每次拿2个桔子，小朋友B每次拿3个桔子，小朋友C每次拿1个桔子，
 * 小朋友10s吃1个桔子，吃完后继续去拿。
 * 小朋友每次拿桔子之前和拿了桔子之后，都会对桔子数量进行报数。如果剩余的桔子不够小朋友每次拿的数量，小朋友停止拿桔子，喊一声“不拿了”并退出游戏’
 */
class Orange{
    private volatile int total = 9;
    private Lock lock = new ReentrantLock();

    public void getOrange(int count){
        while(total >= count){
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "拿之前有" + total + "个橘子");
                total -= count;
                System.out.println(Thread.currentThread().getName() + "拿之后有" + total + "个橘子");
            } finally {
                lock.unlock();
            }
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        System.out.println(Thread.currentThread().getName() + "\t不拿了");
    }
}
public class TestDemo {
    public static void main(String[] args) {
        Orange orange = new Orange();

        new Thread(() -> {
            orange.getOrange(2);
        },"小朋友A").start();

        new Thread(() -> {
            orange.getOrange(3);
        },"小朋友B").start();

        new Thread(() -> {
            orange.getOrange(1);
        },"小朋友C").start();
    }
}
