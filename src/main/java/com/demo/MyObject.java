package com.demo;

public class MyObject {
    public static void main(String[] args) {
        // 如果是jdk自带的，走的是Bootstrap(启动类加载器)
        Object object = new Object();
        System.out.println(object.getClass().getClassLoader());

        System.out.println("----------------------------------------------------");

        // 如果是自己new的，走的是AppClassLoader(应用程序类加载器)
        MyObject myObject = new MyObject();
        System.out.println(myObject.getClass().getClassLoader());
        System.out.println(myObject.getClass().getClassLoader().getParent());
        System.out.println(myObject.getClass().getClassLoader().getParent().getParent());
    }
}
