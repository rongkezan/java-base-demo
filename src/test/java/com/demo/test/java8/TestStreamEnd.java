package com.demo.test.java8;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 终止操作
 */
public class TestStreamEnd {
    private List<Employee> emps;

    @Data
    @AllArgsConstructor
    public static class Employee{
        private String name;
        private Integer age;
        private Double salary;
        private Status status;

        public enum Status{
            FREE,
            BUSY,
            VOCATION
        }
    }

    @Before
    public void before(){
        emps = Arrays.asList(
                new Employee("张三", 19, 2200.00, Employee.Status.FREE),
                new Employee("李四", 28, 2600.00, Employee.Status.BUSY),
                new Employee("王五", 22, 2100.00, Employee.Status.VOCATION),
                new Employee("赵六", 58, 5500.00, Employee.Status.FREE),
                new Employee("阿七", 17, 100.00, Employee.Status.VOCATION),
                new Employee("阿七", 17, 100.00, Employee.Status.FREE)
        );
    }

    @Test
    public void test1(){
        // 是否匹配所有元素 allMatch
        boolean b = emps.stream().allMatch(e -> e.getStatus().equals(Employee.Status.BUSY));

        // 至少匹配一个元素 anyMatch
        boolean b1 = emps.stream().anyMatch(e -> e.getStatus().equals(Employee.Status.BUSY));

        // 检查是否没有匹配所有元素 noneMatch
        boolean b2 = emps.stream().noneMatch(e -> e.getStatus().equals(Employee.Status.BUSY));

        // 倒排后返回第一个元素 findFirst
        Optional<Employee> op = emps.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).findFirst();
        System.out.println(op.get());

        // 返回任意元素的值 findAny
        Optional<Employee> op1 = emps.stream().filter(e -> e.getStatus().equals(Employee.Status.FREE)).findAny();
        System.out.println(op1.get());

        // 返回元素总个数 count
        long count = emps.stream().count();

        // 返回流中最大值 max
        Optional<Employee> max = emps.stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(max.get());

        // 返回流中最小值 min
        Optional<Double> min = emps.stream().map(Employee::getSalary).min(Double::compare);
        System.out.println(min.get());
    }

    /**
     * 归约   可以将流中的元素反复结合起来，得到一个值
     * reduce(T identity, BinaryOperator)
     * reduce(BinaryOperator)
     */
    @Test
    public void test2(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        System.out.println("---------------------");
        Optional<Double> op = emps.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(op.get());
    }

    /**
     * 收集
     * collect  将流转换为其它形式，接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
     */
    @Test
    public void test3(){
        List<String> list = emps.stream().map(Employee::getName).collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println("-----------------------");
        HashSet<String> set = emps.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
        set.forEach(System.out::println);
    }

    // 分组
    @Test
    public void test4(){
        Map<Employee.Status, List<Employee>> map = emps.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);
    }

    // 多级分组
    @Test
    public void test5(){
        Map<Employee.Status, Map<String, List<Employee>>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(e -> {
            if (e.getAge() <= 35) {
                return "青年";
            } else {
                return "老年";
            }
        })));
        System.out.println(map);
    }

    // 分区
    @Test
    public void test6(){
        Map<Boolean, List<Employee>> map = emps.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 8000));
        System.out.println(map);
    }

    // 统计
    @Test
    public void test7(){
        DoubleSummaryStatistics summary = emps.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(summary.getSum());
        System.out.println(summary.getAverage());
        System.out.println(summary.getMax());
    }

    // 拼接
    @Test
    public void test8(){
        String str = emps.stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println(str);
    }
}
