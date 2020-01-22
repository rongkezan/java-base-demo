package com.demo.thread;


/**
 * Thread类常用方法
 * void start()         启动当前线程，调用当前线程的run()
 * run()
 * currentThread()      返回当前线程
 * String getName()     获取当前线程名称
 * void setName()       设置当前线程名称
 * yield()              释放当前Cpu执行权
 * join()               在线程A中调用线程B的join()，此时线程A进入阻塞状态，直到线程B完全执行完以后，线程A才结束阻塞状态
 * boolean isAlive()    判断线程是否还活着
 * sleep()              让当前线程"睡眠"指定的毫秒数
 */
public class TestTreadMethod {
    static class MyThread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try { sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
                if(i % 2 == 0){
                    System.out.println(Thread.currentThread().getName() + "\t" + i);
                }
                if (i % 20 == 0){
                    yield();
                }
            }
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.setName("t1");
        t1.start();
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            if (i == 20){
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(t1.isAlive());
    }
}
