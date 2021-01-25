package com.demo.juc.waitNotify;

/**
 * Object wait notify
 * 1. 必须在同步代码块中才会生效
 * 2. 先notify后wait后线程会一直等待
 *
 * @author keith
 */
public class WaitNotifyDemo {
    static Object objectsMonitor = new Object();

    public static void main(String[] args) {
        new Thread(() ->{
            synchronized (objectsMonitor){
                System.out.println(Thread.currentThread().getName() + "\t" + "come in");
                try { objectsMonitor.wait(); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName() + "\t" + "wake up");
                objectsMonitor.notifyAll();
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (objectsMonitor){
                objectsMonitor.notify();
                System.out.println(Thread.currentThread().getName() + "\t" + "notify and wait");
                try {
                    objectsMonitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "wake up");
            }
        }, "B").start();


    }
}
