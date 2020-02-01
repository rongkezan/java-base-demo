package com.demo.juc;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * 全局锁:
 * 1. 在synchronized代码块传入监视器类型为 类对象 即为全局锁
 * 2. synchronized 静态方法 即为全局锁
 */
public class GlobalLockDemo {
    static class Data{
        public static int num = 10;

        @SneakyThrows
        public void test(){
            synchronized (Data.class){
                System.out.println(Thread.currentThread().getName() + "减之前\t" + num);
                num --;
                System.out.println(Thread.currentThread().getName() + "减之后\t" + num);
                TimeUnit.SECONDS.sleep(2);
            }
        }
    }
    public static void main(String[] args) {
        Data data1 = new Data();
        Data data2 = new Data();

        new Thread(() -> {
            data1.test();
        }, "A").start();

        new Thread(() -> {
            data2.test();
        }, "B").start();
    }
}
