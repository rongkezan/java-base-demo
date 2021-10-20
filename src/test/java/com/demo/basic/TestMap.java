package com.demo.basic;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMap {

    /**
     * Compute: 没有Key就新建 有就覆盖
     */
    @Test
    public void compute() {
        List<Student> list = Arrays.asList(
                new Student(1, "a", 10),
                new Student(1, "b", 20),
                new Student(2, "c", 40),
                new Student(2, "d", 70),
                new Student(3, "e", 80)
        );
        Map<Integer, Student> map = new HashMap<>();
        for (Student student : list) {
            map.compute(student.id, (k, v) -> student);
        }
        System.out.println(map);
    }

    @AllArgsConstructor
    @ToString
    private static class Student {

        public Integer id;

        public String name;

        public Integer score;
    }
}
