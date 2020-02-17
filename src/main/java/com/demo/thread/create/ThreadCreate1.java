package com.demo.thread.create;

/**
 * 线程创建方式1: 继承Thread类
 */
public class ThreadCreate1 {
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "\t 运行了...");
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();
    }
}
