package com.demo.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 验证volatile不保证原子性
 * 原子性：不可分割，完整性，即某个线程在做某个具体业务时，中间不可以被加塞或分割。要么同时成功，要么同时失败。
 */
public class VolatileAtomicDemo {
    private static class MyData{
        private volatile int num = 0;

        public void addPlus(){
            num ++;
        }

        AtomicInteger atomicNum = new AtomicInteger();

        public void addAtomic(){
            atomicNum.getAndIncrement();
        }
    }

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

        System.out.println("普通结果\t" + myData.num);
        System.out.println("Atomic结果\t" + myData.atomicNum);
    }
}
