package com.demo.basic;

public class StringReference {

    public static void main(String[] args) {
        String str = null;
        fun(str);
        System.out.println(str);
    }

    static void fun(String str){
        str = "abc";
    }
}
