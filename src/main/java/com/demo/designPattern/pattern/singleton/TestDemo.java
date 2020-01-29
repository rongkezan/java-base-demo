package com.demo.designPattern.pattern.singleton;

public class TestDemo {
    public static void main(String[] args) {
        Singleton1 s1 = Singleton1.INSTANCE;
        Singleton2 s2 = Singleton2.INSTANCE;
        Singleton3 s3 = Singleton3.INSTANCE;
        System.out.println(s3);
        System.out.println("---------------------------------");
    }
}
