package com.demo.thread;

import org.junit.Test;

/**
 * 实现Runnable接口创建多线程
 */
public class TestThreadCreate2 {
    static class MyThread implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                if(i % 2 == 0){
                    System.out.println(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.start();
    }
}
