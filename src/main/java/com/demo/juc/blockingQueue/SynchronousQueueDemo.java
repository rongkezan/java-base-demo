package com.demo.juc.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列
 *  当阻塞队列是空时，从队列里获取元素会被阻塞
 *  当阻塞队列是满时，从队列里添加元素会被阻塞
 * ArrayBlockingQueue: 由数组结构组成的有界阻塞队列
 * LinkedBlockingQueue: 由链表组成的有界阻塞队列，但默认界限为Integer.MAX_VALUE
 * SynchronousQueue: 单个元素的队列，即生产一个消费一个，不消费不生产,每一个put操作需要等待一个take操作
 *
 * 方法
 *  抛异常：add(e) remove() element()
 *  特殊值：offer(e) poll() peek()
 *  一直阻塞：put(e) take()
 *  超时退出：offer(e, time, unit) poll(time, unit)
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t put 1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName() + "\t put 2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName() + "\t put 3");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "\t" + blockingQueue.take());
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "\t" + blockingQueue.take());
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "\t" + blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();

    }
}
