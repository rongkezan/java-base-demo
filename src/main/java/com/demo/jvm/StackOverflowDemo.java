package com.demo.jvm;

/**
 * 演示StackOverflow错误(不是异常)
 * method() 递归调用自己，使栈溢出
 */
public class StackOverflowDemo {

    public static void method(){
        method();
    }

    public static void main(String[] args) {
        System.out.println("--- Main线程开始 ---");
        method();
        System.out.println("--- Main线程结束 ---");
    }
}
