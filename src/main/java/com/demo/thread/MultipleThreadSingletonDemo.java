package com.demo.thread;

/**
 * DCL双端锁不一定线程安全，原因是有指令重排，加入volatile可以禁止指令重排
 * 某一个线程执行到第一次检测，读取到的instance不为null时，instance引用可能并没有完成实例化
 * instance = new DLCDemo01() 可以分为以下三个步骤
 *  1.memory = allocate() 分配对象的内存空间
 *  2.instance(memory)    初始化对象
 *  3.instance = memory   设置instance指向刚刚分配的内存地址,此时instance != null
 * 由于步骤2 步骤3不存在数据的依赖关系,而且无论重拍前还是重排后的执行结果在单线程中并没有发生改变,所以这样的重排优化是允许的
 *  1.memory = allocate() 分配对象的内存空间
 *  3.instance = memory   设置instance指向刚刚分配的内存地址,此时instance != null ,但是对象还没有初始化完成
 *  2.instance(memory)    初始化对象
 * 所以当一条线程访问instance不为null时,由于instance实例未必已初始化完成,也就造成了线程安全问题
 */
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
