package com.demo.design.pattern.singleton;

/**
 * DCL (Double Check Lock)
 * 当多线程调用getInstance方法时，可能出现线程安全问题，需要加锁
 * 为提高效率，需细化锁的粒度，方法内加锁又需要判空一次
 *
 * instance需要加volatile，目的是禁止指令重排
 *
 * instance实例化的过程是:
 * 1.申请内存空间 -> 2.初始化对象 -> 3.将instance指向刚分配的内存空间
 * 指令重排后为 1 -> 3 -> 2
 * A线程判断instance == null后进入锁内方法实例化instance
 * B线程判断instance != null后直接获取该对象
 * 但是指令重排后的A刚初始化了对象，B在A之前访问了这个对象，导致B线程获取到一个空对象
 */
public class Singleton5 {
    private static volatile Singleton5 instance;

    private Singleton5(){

    }

    public static Singleton5 getInstance(){
        if (instance == null){
            synchronized (Singleton5.class){
                if (instance == null){
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}
