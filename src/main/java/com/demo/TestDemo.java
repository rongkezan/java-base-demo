package com.demo;

public class TestDemo {
    static class A{
        private static int m = 10;
        static{
            m = 30;
        }
    }
    public static void main(String[] args) {
        System.out.println(A.m);
    }
}
