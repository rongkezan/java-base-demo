package com.demo.thread;

/**
 * ThreadLocal用法
 */
public class MyThreadLocal {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    // 运行3个线程，每个线程拥有自己独有的编号
    public void startThreadArray(){
        Thread[] runs = new Thread[3];
        // 把i作为线程的编号，赋给线程，并启动
        for (int i = 0; i < runs.length; i++) {
            runs[i] = new Thread(new TestThread(i));
            runs[i].start();
        }
    }

    public static class TestThread implements Runnable{
        int id;
        public TestThread(int id){
            this.id = id;
        }
        @Override
        public void run() {
            threadLocal.set("线程-" + id);
            System.out.println(Thread.currentThread().getName() + "编号:\t" + threadLocal.get());
        }
    }

    public static void main(String[] args) {
        MyThreadLocal test = new MyThreadLocal();
        test.startThreadArray();
    }
}
