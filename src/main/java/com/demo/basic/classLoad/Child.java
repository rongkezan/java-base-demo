package com.demo.basic.classLoad;

/**
 * 加载顺序: 静态 > 构造块 > 构造方法
 *
 * 1. 类初始化 <clinit>
 * 静态方法 -> 静态代码块
 * 先初始化父类后初始化子类
 *
 * 2. 实例初始化 <init>
 * 组成: 非静态实例变量、非静态代码块、对应构造器代码
 * 顺序: 非静态实例变量、非静态代码块 从上到下顺序执行，构造器代码最后执行
 *
 * super() -> 非静态变量 -> 非静态代码块 -> 无参构造
 *
 * 注意: method()执行的是子类重写的方法(面向多态)
 */
public class Child extends Parent {
    private int i = param();
    private static int j = staticParam();

    static {
        System.out.println("子类静态代码块");
    }

    Child(){
        System.out.println("子类构造方法");
    }

    {
        System.out.println("子类代码块");
    }

    @Override
    public int param(){
        System.out.println("子类实例变量");
        return 1;
    }

    public static int staticParam(){
        System.out.println("子类静态实例变量");
        return 1;
    }
}
