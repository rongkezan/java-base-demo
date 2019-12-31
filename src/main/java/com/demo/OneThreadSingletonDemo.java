package com.demo;

public class OneThreadSingletonDemo {

    private static OneThreadSingletonDemo instance = null;

    public OneThreadSingletonDemo(){
        System.out.println(Thread.currentThread().getName() + "\t 构造方法初始化");
    }

    public static OneThreadSingletonDemo getInstance(){
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
