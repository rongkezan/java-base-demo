package com.demo.juc.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 *  可以多人读，但只允许一人写
 *
 *  写操作：原子 + 独占
 */
public class ReadWriteLockDemo {
    private static class MyCache{
        private volatile Map<String, Object> map = new HashMap<>();

        private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

        public void put(String key, Object val){
            rwLock.writeLock().lock();
            try {
                TimeUnit.MILLISECONDS.sleep(300);
                System.out.println(Thread.currentThread().getName() + "\t正在写入...");
                map.put(key, val);
                System.out.println(Thread.currentThread().getName() + "\t写入完成:" + key);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                rwLock.writeLock().unlock();
            }
        }

        public void get(String key){
            rwLock.readLock().lock();
            try {
                TimeUnit.MILLISECONDS.sleep(300);
                System.out.println(Thread.currentThread().getName() + "\t正在读取...");
                Object res = map.get(key);
                System.out.println(Thread.currentThread().getName() + "\t读取完成:" + res);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                rwLock.readLock().unlock();
            }
        }
    }

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
