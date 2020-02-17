package com.demo.thread.create;

/**
 * 线程创建方式2: 实现Runnable接口
 */
public class ThreadCreate2 {
    static class MyThread implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "\t 运行了...");
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        new Thread(t1).start();
        new Thread(t2).start();
    }
}
