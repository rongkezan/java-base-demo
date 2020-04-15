package com.demo.juc;

import java.util.concurrent.TimeUnit;

/**
 * JMM 可见性: 通知机制
 * 验证volatile可见性
 * 假如 int num = 0; num 变量之前不添加volatile关键字，没有可见性
 */
public class VolatileVisibleDemo {
    private static class MyData{
        // 若是不加 volatile，那么main线程就接收不到通知
        volatile int num = 0;

        public void change(){
            this.num = 60;
        }
    }

    public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
            myData.change();
            System.out.println(Thread.currentThread().getName() + "\t updated number value:" + myData.num);
        }, "A").start();

        while(myData.num == 0){
            // 需要有一种通知机制告诉main线程 num 已经修改，跳出while
        }
        System.out.println(Thread.currentThread().getName() + "\t main get number value:" + myData.num);
    }
}
