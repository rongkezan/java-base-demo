package com.demo;

public class MultipleThreadSingletonDemo {

    private static volatile MultipleThreadSingletonDemo instance = null;

    private MultipleThreadSingletonDemo(){
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法");
    }

    public static MultipleThreadSingletonDemo getInstance(){
        if(instance == null){
            synchronized (MultipleThreadSingletonDemo.class){
                if(instance == null){
                    instance = new MultipleThreadSingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        //并发多线程
        for(int i = 0; i < 10; i++){
            new Thread(() -> {
              MultipleThreadSingletonDemo.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
