package com.demo.collection.entity;

import java.util.Objects;

public class Student{
    private Long id;
    private String name;
    private Integer age;
    private Integer grade;
    private String major;
    private String school;

    public Student(Long id, String name, Integer age, Integer grade, String major, String school) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.major = major;
        this.school = school;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) &&
                Objects.equals(name, student.name) &&
                Objects.equals(age, student.age) &&
                Objects.equals(grade, student.grade) &&
                Objects.equals(major, student.major) &&
                Objects.equals(school, student.school);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, grade, major, school);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                ", major='" + major + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
