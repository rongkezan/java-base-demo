package com.demo.designPattern.pattern.singleton;

/**
 * 懒汉式: 延迟创建实例对象
 *
 * 1. 构造器私有化
 * 2. 用一个静态变量保存这个唯一实例
 * 3. 提供一个静态方法，获取这个实例对象
 *
 * 本例有线程安全问题，适用于单线程
 */
public class Singleton4 {

    static Singleton4 instance;

    private Singleton4(){

    }

    public static Singleton4 getInstance(){
        if (instance == null){
            instance = new Singleton4();
        }
        return instance;
    }
}
