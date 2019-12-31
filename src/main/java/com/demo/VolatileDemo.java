package com.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData{
    volatile int num = 0;

    public void change(){
        this.num = 60;
    }

    public void addPlus(){
        num ++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public synchronized void addAtomic(){
        atomicInteger.getAndIncrement();
    }
}

/**
 * 1.验证volatile可见性
 *  假如 int num = 0; num 变量之前不添加volatile关键字，没有可见性
 * 2.验证volatile不保证原子性
 *  原子性：不可分割，完整性，即某个线程在做某个具体业务时，中间不可以被加塞或分割。要么同时成功，要么同时失败。
 */
public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();
        for(int i = 0; i < 20; i++){
            new Thread(() -> {
                for(int j = 0; j < 1000; j++){
                    myData.addPlus();
                    myData.addAtomic();
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t int type, final number value:" + myData.num);
        System.out.println(Thread.currentThread().getName() + "\t AtomicInteger, final number value:" + myData.atomicInteger);
    }

    public static void visiable(){
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.change();
            System.out.println(Thread.currentThread().getName() + "\t updated number value:" + myData.num);
        }, "aaa").start();

        while(myData.num == 0){
            // main线程一直等待循环，直到number值不再为0
        }

        System.out.println(Thread.currentThread().getName() + "\t mission is over, main get number value:" + myData.num);
    }
}
