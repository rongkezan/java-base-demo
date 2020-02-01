package com.demo.designPattern.pattern.singleton;

public class TestDemo {
    public static void main(String[] args) {
        Singleton1 s1 = Singleton1.INSTANCE;
        Singleton2 s2 = Singleton2.INSTANCE;
        Singleton3 s3 = Singleton3.INSTANCE;
        Singleton4 s4 = Singleton4.getInstance();
        Singleton4 s5 = Singleton4.getInstance();
        System.out.println(s4 == s5);
        System.out.println(s3);
        System.out.println("---------------------------------");
    }
}
