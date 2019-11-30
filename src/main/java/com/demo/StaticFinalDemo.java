package com.demo;

/**
 * 对比static和final的区别
 * - static：只保存一份工作副本
 * - final：保证变量不可变
 *
 * 示例输出：
 * 0.6192912108264766
 * 0.6192912108264766
 * 0.8597710219646246
 * 0.7240744274681449
 */
public class StaticFinalDemo {
    public static void main(String[] args) {
        MyRandom random1 = new MyRandom();
        MyRandom random2 = new MyRandom();

        System.out.println(random1.a);
        System.out.println(random2.a);

        System.out.println(random1.b);
        System.out.println(random2.b);
    }
}

class MyRandom{
    protected static double a = Math.random();
    protected final double b = Math.random();
}
