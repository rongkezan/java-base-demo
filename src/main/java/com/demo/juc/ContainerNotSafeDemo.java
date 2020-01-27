package com.demo.juc;

import java.util.*;

/**
 * 集合类不安全问题
 *  异常: ConcurrentModificationException
 * 导致原因:
 *  并发争抢修改，一个线程正在修改，另一个线程来争夺，导致数据不一致异常。
 * 解决方案:
 * 1. Vector
 * 2. Collections.synchronizedList(new ArrayList())
 * 3. CopyOnWriteList()
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }).start();
        }
    }
}
