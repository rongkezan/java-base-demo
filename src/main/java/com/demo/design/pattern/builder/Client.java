package com.demo.design.pattern.builder;

/**
 * 使用建造者模式可以在参数不确定的情况下构建实体
 */
public class Client {
    public static void main(String[] args) {
        User user = User.builder().name("Jerry").age(18).build();
        System.out.println(user);
    }
}
