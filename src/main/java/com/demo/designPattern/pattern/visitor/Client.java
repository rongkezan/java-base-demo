package com.demo.designPattern.pattern.visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * 场景: 观众有男生和女生，分别对歌手进行评价，有两个等级 -- 好、差
 */
abstract class Action{
    public abstract void getManConclusion(Man man);

    public abstract void getWomanConclusion(Woman woman);
}

class Good extends Action{

    @Override
    public void getManConclusion(Man man) {
        System.out.println("男生给的评价是好");
    }

    @Override
    public void getWomanConclusion(Woman woman) {
        System.out.println("女生给的评价是好");
    }
}

class Bad extends Action{

    @Override
    public void getManConclusion(Man man) {
        System.out.println("男生给的评价是坏");
    }

    @Override
    public void getWomanConclusion(Woman woman) {
        System.out.println("女生给的评价是坏");
    }
}

abstract class Person{
    // 提供一个方法，让访问者可以访问
    public abstract void accept(Action action);
}

class Man extends Person{

    @Override
    public void accept(Action action) {
        action.getManConclusion(this);
    }
}

class Woman extends Person{

    @Override
    public void accept(Action action) {
        action.getWomanConclusion(this);
    }
}

// 数据结构，管理很多人
class ObjectStructure{
    private List<Person> personList = new LinkedList<>();

    public void attach(Person p){
        personList.add(p);
    }

    public void detach(Person p){
        personList.remove(p);
    }

    public void display(Action action){
        for (Person person : personList) {
            person.accept(action);
        }
    }
}

public class Client {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attach(new Man());
        objectStructure.attach(new Woman());

        Good good = new Good();
        Bad bad = new Bad();

        objectStructure.display(good);
        objectStructure.display(bad);
    }
}
