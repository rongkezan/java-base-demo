package com.demo.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者消费者模式
 * 生产一个消费一个
 */
class MyResource{
    private volatile boolean flag = true;   // 默认开启，进行生产+消费
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void prod() throws Exception{
        String data = null;
        boolean retValue = false;
        while(flag){
            data = String.valueOf(atomicInteger.incrementAndGet());
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue){
                System.out.println(Thread.currentThread().getName() + "\t插入队列" + data + "成功");
            } else{
                System.out.println(Thread.currentThread().getName() + "\t插入队列" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\tflag = false了，生产动作结束");
    }

    public void consume() throws Exception{
        String result = null;
        while (flag){
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (result == null || result.equalsIgnoreCase("")){
                flag = false;
                System.out.println(Thread.currentThread().getName() + "\t超过2秒钟没有取到蛋糕，消费退出");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t消费队列" + result + "成功");
        }
    }

    public void stop() throws Exception{
        this.flag = false;
    }
}
public class ProdConsumerDemo {
    public static void main(String[] args) throws Exception {
        MyResource myResource = new MyResource(new SynchronousQueue<>());
        new Thread(() -> {
            try {
                System.out.println("生产者线程开始");
                myResource.prod();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "prod").start();

        new Thread(() -> {
            try {
                System.out.println("消费者线程开始");
                myResource.consume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "consumer").start();

        TimeUnit.SECONDS.sleep(5);
        System.out.println("5秒钟时间到");
        myResource.stop();
    }
}
