package com.demo.basic.classLoad;

public class Parent {
    private int i = param();
    private int a = paramParent();
    private static int j = staticParam();

    static{
        System.out.println("父类静态代码块");
    }

    Parent(){
        System.out.println("父类构造方法");
    }

    {
        System.out.println("父类代码块");
    }

    public int param(){
        System.out.println("父类实例变量1");
        return 1;
    }

    public int paramParent(){
        System.out.println("父类实例变量2");
        return 1;
    }

    public static int staticParam(){
        System.out.println("父类静态实例变量");
        return 1;
    }
}
