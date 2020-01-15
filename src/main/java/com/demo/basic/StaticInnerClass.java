package com.demo.basic;

/**
 * 静态内部类
 * 如果一个类要被声明为static，只有一种情况，就是静态内部类
 *  1. 静态内部类和静态方法一样，只能访问静态的成员变量和方法，不能访问非静态的方法和属性，但普通内部类可以访问任意外部类的成员和方法
 *  2. 静态内部类可以声明普通成员变量和方法，而普通内部类不能声明static成员变量和方法
 */
public class StaticInnerClass {
    public static void main(String[] args) {
        Outer2.TestDemo testDemo = new Outer2.TestDemo();
        System.out.println(testDemo);
    }
}

class Outer2{
    static class TestDemo{
        public TestDemo(){
            System.out.println("--- 我被实例化了 ---");
        }
    }
}
