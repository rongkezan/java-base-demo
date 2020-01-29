package com.demo.basic.reflection.entity;

import java.util.Comparator;

@MyAnnotation("hi")
public class Person extends Creature<String> implements Comparator<String>, MyInterface {

    private String name;
    protected int age;
    public int id;

    public Person(){

    }

    @MyAnnotation()
    private Person(String name){
        this.name = name;
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @MyAnnotation()
    private String show(String nation){
        System.out.println("我的国籍是: " + nation);
        return nation;
    }

    private static String display(String hobby) throws NullPointerException{
        return hobby;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    @Override
    public int compare(String o1, String o2) {
        return 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
