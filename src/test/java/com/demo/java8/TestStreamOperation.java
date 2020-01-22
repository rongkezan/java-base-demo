package com.demo.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream流的中间操作
 */
public class TestStreamOperation {

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
                new Employee("阿七", 17, 100.00),
                new Employee("阿七", 17, 100.00)
        );
    }

    /**
     * 筛选和切片
     * - filter     接收lambda，从流冲排除某些元素
     * - limit      截断流，使其元素不超过给定数量
     * - skip(n)    跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个，则返回一个空流，与limit互补
     * - distinct   筛选，通过流所生成元素的hashCode()和equals()去除重复元素
     */
    @Test
    public void test1(){
        Stream<Employee> stream = emps.stream().filter(e -> e.getAge() > 22);
        stream.forEach(System.out::println);
    }

    @Test
    public void test2(){
        emps.stream().filter(e -> e.getSalary() >= 100).limit(3).forEach(System.out::println);
    }

    @Test
    public void test3(){
        emps.stream().filter(e -> e.getSalary() >= 100).skip(1).forEach(System.out::println);
    }

    @Test
    public void test4(){
        emps.stream().filter(e -> e.getSalary() >= 100).distinct().forEach(System.out::println);
    }

    /**
     * 映射
     * map      接收lambda，将元素转换成其它形式或提取信息。接收另一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新元素。
     * flatMap  接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
     */
    @Test
    public void test5(){
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        System.out.println("-------------------");
        emps.stream().map(Employee::getName).forEach(System.out::println);

    }

    @Test
    public void test6(){
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        Stream<Stream<Character>> stream = list.stream().map(TestStreamOperation::filterCharacter);
        stream.forEach(sm -> sm.forEach(System.out::println));  //{{a,a,a}, {b,b,b} ...}
        System.out.println("-------------------");
        Stream<Character> stream1 = list.stream().flatMap(TestStreamOperation::filterCharacter);
        stream1.forEach(System.out::println);   // {a,a,a,b,b,b}
    }

    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()){
            list.add(ch);
        }
        return list.stream();
    }

    /**
     * 排序
     * sorted()                 自然排序(Comparable)
     * sorted(Comparator com)   定制排序(Comparator)
     */
    @Test
    public void test7(){
        List<String> list = Arrays.asList("ddd", "eee", "aaa", "bbb", "ccc");
        list.stream().sorted().forEach(System.out::println);
        System.out.println("---------------------");
        emps.stream().sorted((e1, e2) -> {
            if(e1.getAge().equals(e2.getAge())){
                return e1.getName().compareTo(e2.getName());
            } else{
                return e1.getAge().compareTo(e2.getAge());
            }
        }).forEach(System.out::println);
    }
}