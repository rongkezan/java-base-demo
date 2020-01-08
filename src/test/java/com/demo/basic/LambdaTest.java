package com.demo.basic;

import org.junit.Test;

/**
 * 前提：
 *  一个接口类只允许出现一个抽象方法
 * 形式：
 *  1. (参数, 参数, ...) -> {方法体;}
 *  2. 参数 -> 计算表达式;
 * 定义函数接口：
 *  使用注解@FunctionalInterface
 *  若有多个抽象方法，则会报错
 * 目的：
 *  简化匿名内部类的使用
 */

@FunctionalInterface
interface IMessage{
    void send(String msg);
}

public class LambdaTest {
    @Test
    public void testLambda(){
        IMessage msg = str -> System.out.println(str);
        msg.send("www.baidu.com");
    }
}
