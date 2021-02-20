package com.demo.design.pattern.visitor;

/**
 * 校长：访问者
 * @author keith
 */
public class Principal implements Visitor {

    public void visit(Student student) {
        System.out.println("学生姓名:" + student.name + ",班级:" + student.clazz);
    }
}
