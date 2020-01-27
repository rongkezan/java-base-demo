package com.demo.example.init;

/**
 * 1. 类初始化 <clinit>
 * 静态方法 -> 静态代码块
 * 先初始化父类 5 1
 * 初始化子类 10 6
 *
 * 2. 实例初始化 <init>
 * 组成: 非静态实例变量、非静态代码块、对应构造器代码
 * 顺序: 非静态实例变量、非静态代码块 从上到下顺序执行，构造器代码最后执行
 *
 * super() -> 非静态变量 -> 非静态代码块 -> 无参构造
 *
 * 注意: test()执行的是子类重写的方法(面向多态)
 */
public class Son extends Father {
    private int i = test();
    private static int j = method();

    static {
        System.out.println("6");
    }

    Son(){
        System.out.println("7");
    }

    {
        System.out.println("8");
    }

    @Override
    public int test(){
        System.out.println("9");
        return 1;
    }

    public static int method(){
        System.out.println("10");
        return 1;
    }

    public static void main(String[] args) {
        Son s1 = new Son();
        System.out.println();
        Son s2 = new Son();

        Class<Son> sonClass = Son.class;
    }
}
