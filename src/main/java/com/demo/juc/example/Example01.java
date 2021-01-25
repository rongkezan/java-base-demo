package com.demo.juc.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * 实现一个容器 给出两个方法 add size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示结束
 */
public class Example01 {
    static List<String> list = new ArrayList<>();

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        t1 = new Thread(() -> {
            if (list.size() != 5) {
                LockSupport.park();
            }
            System.out.println("list元素达到5个");
            LockSupport.unpark(t2);
        }, "B");


        t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (list.size() == 5) {
                    LockSupport.unpark(t1);
                    LockSupport.park();
                }
                list.add("1");
                System.out.println("add " + i);
            }
        }, "A");

        t1.start();
        t2.start();
    }
}
