package com.demo.design.pattern.visitor;


/**
 * 父母：访问者
 * @author keith
 */
public class Parent implements Visitor {

    public void visit(Student student) {
        System.out.println("学生姓名:" + student.name + ",排名:" + student.ranking());
    }
}
