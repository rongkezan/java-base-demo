package com.demo.basic;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 变量作用域
 */
public class TransferValue {
    public void changeValue1(int age){
        age = 30;
    }

    public void changeValue2(Person person){
        person.setName("xxx");
    }

    public void changeValue3(String str){
        str = "xxx";
    }

    public static void main(String[] args) {
        TransferValue tv = new TransferValue();

        // 基本类型传复印件
        int age = 20;
        tv.changeValue1(age);
        System.out.println("age = " + age);

        // 引用类型传的是内存地址
        Person person = new Person("abc");
        tv.changeValue2(person);
        System.out.println("personName = " + person.getName());

        // 字符串常量池在元空间
        // 有，直接复用；没有，在常量池里新建
        String str = "abc";
        tv.changeValue3(str);
        System.out.println("String = " + str);
    }

    @Data
    @AllArgsConstructor
    private static class Person{
        private String name;
    }
}

