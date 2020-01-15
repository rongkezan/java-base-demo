package com.demo.thread;

/**
 * 单线程下的单例模式
 */
public class OneThreadSingletonDemo {

    private static OneThreadSingletonDemo instance = null;

    public OneThreadSingletonDemo(){
        System.out.println(Thread.currentThread().getName() + "\t 构造方法初始化");
    }

    public static synchronized OneThreadSingletonDemo getInstance(){
        if(instance == null){
            instance = new OneThreadSingletonDemo();
        }
        return instance;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 3; i++){
            System.out.println(OneThreadSingletonDemo.getInstance() == OneThreadSingletonDemo.getInstance());
        }
    }
}
