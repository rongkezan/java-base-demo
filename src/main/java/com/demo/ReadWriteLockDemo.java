package com.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 *  可以多人读，但只允许一人写
 *  读-读 能共存
 *  读-写 不能共存
 *  写-写 不能共存
 *
 *  写操作：原子 + 独占
 */
class MyCache{
    private volatile Map<String, Object> map = new HashMap<>();

    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key, Object val){
        rwLock.writeLock().lock();
        try {
            try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName() + "\t 正在写入:" + key);
            map.put(key, val);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成:" + key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public void get(String key){
        rwLock.readLock().lock();
        try {
            try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName() + "\t 正在读取:" + key);
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取完成:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }
    }

}

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for(int i = 0; i < 5; i++){
            final int tempInt = i;
            new Thread(() -> {
                myCache.put(tempInt + "", tempInt + "");
            }, String.valueOf(i)).start();
        }

        for(int i = 0; i < 5; i++){
            final int tempInt = i;
            new Thread(() -> {
                myCache.get(tempInt + "");
            }, String.valueOf(i)).start();
        }
    }
}
