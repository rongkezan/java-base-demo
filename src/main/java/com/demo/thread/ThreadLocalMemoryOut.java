package com.demo.thread;

/**
 * 测试 ThreadLocal 内存泄漏
 * @author keith
 */
public class ThreadLocalMemoryOut {

    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("111");
        System.out.println(threadLocal.get());
        threadLocal = new ThreadLocal<>();
        threadLocal.set("222");
        System.out.println(threadLocal.get());
    }
}
