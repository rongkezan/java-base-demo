package com.demo.jvm;

/**
 * 实际生产上必须将初始内存和最大内存调成一样，避免内存忽高忽低，产生停顿
 * Jvm配置
 *  -Xms1024m 最小内存1024m
 *  -Xmx1024m 最大内存1024m
 *  -XX:+PrintGCDetails 打印GC详情
 * Vm Options: -Xms1024m -Xmx1024m -XX:+PrintGCDetails
 *
 * java.lang.OutOfMemoryError:Java heap space
 */
public class CheckHardware {
    public static void main(String[] args) {
        System.out.println("--- Cpu的核数 ---");
        System.out.println(Runtime.getRuntime().availableProcessors());

        System.out.println("--- JVM试图使用的最大内存量 ---");
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("-Xmx:" + maxMemory / 1024 / 1024 + "MB");

        System.out.println("--- JVM内存总量 ---");
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("-Xms:" + totalMemory / 1024 / 1024 + "MB");
    }
}
