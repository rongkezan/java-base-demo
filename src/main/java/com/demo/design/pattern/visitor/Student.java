package com.demo.design.pattern.visitor;

/**
 * 学生：被访问对象
 * @author keith
 */
public class Student {
    public String name;     // 姓名
    public String identity; // 身份：重点班、普通班
    public String clazz;    // 班级

    public Student(String name, String identity, String clazz) {
        this.name = name;
        this.identity = identity;
        this.clazz = clazz;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int ranking() {
        return (int) (Math.random() * 100);
    }
}
