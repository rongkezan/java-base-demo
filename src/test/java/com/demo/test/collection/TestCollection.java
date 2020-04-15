package com.demo.test.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestCollection {

    private List<Employee> emps;

    @Data
    @AllArgsConstructor
    public static class Employee{
        private String name;
        private Integer age;
        private Double salary;
    }

    @Before
    public void before(){
        emps = Arrays.asList(
                new Employee("张三", 19, 2200.00),
                new Employee("李四", 28, 2600.00),
                new Employee("王五", 22, 2100.00),
                new Employee("赵六", 58, 5500.00),
                new Employee("阿七", 17, 100.00)
        );
    }

    @Test
    public void testSort(){
        Collections.sort(emps, (e1, e2) -> {
            if(e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            } else{
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });
        for (Employee emp : emps){
            System.out.println(emp);
        }
    }
}
