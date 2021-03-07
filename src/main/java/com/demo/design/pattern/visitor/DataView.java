package com.demo.design.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据看板
 * @author keith
 */
public class DataView {
    List<Student> students = new ArrayList<>();

    public DataView() {
        students.add(new Student("谢⻜机", "重点班", "⼀年⼀班"));
        students.add(new Student("windy", "重点班", "⼀年⼀班"));
        students.add(new Student("⼤⽑", "普通班", "⼆年三班"));
        students.add(new Student("Shing", "普通班", "三年四班"));
    }

    public void show(Visitor visitor) {
        for (Student student : students) {
            student.accept(visitor);
        }
    }
}
