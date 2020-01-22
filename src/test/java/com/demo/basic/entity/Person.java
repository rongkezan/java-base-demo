package com.demo.basic.entity;

public class Person{
    private String name;
    private int age;

    public Person(){

    }

    private Person(String name){
        this.name = name;
    }

    private void showNation(String nation){
        System.out.println("Hello World:" + nation);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
