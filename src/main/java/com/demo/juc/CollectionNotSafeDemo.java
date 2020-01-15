package com.demo.juc;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 集合线程非安全
 */
public class CollectionNotSafeDemo {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        for(int i = 0; i < 30; i++){
            new Thread(() -> {
                map.put(Thread.currentThread().toString() ,UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread() + "\t" + map);
            }, String.valueOf(i)).start();
        }
    }

    /**
     * 1. 故障现象
     *      java.util.ConcurrentModificationException
     *
     * 2. 导致原因
     *      并发争抢修改导致，参考花名册签名情况。
     *      一个人正在写，另一个人过来抢夺，导致数据不一致异常 -- 并发修改异常。
     *
     * 3. 解决方案
     *      3.1 new Vector<>()
     *      3.2 Collections.synchronizedList(new ArrayList<>())
     *      3.3 new CopyOnWriteArrayList<>()
     */
    public static void listNotSafe(){
        List<String> list = new CopyOnWriteArrayList<>();
        for(int i = 0; i < 30; i++){
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread() + "\t" + list);
            }, String.valueOf(i)).start();
        }
    }

    /**
     * CopyOnWriteArraySet<>() 底层还是 CopyOnWriteArrayList<>()
     * HashSet 底层是 HashMap, add方法加的是Map的key，值是固定的(Object)
     */
    public static void setNotSafe(){
        Set<String> set = new CopyOnWriteArraySet<>();
        for(int i = 0; i < 30; i++){
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread() + "\t" + set);
            }, String.valueOf(i)).start();
        }
    }
}
