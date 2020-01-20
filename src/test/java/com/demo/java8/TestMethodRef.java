package com.demo.java8;

import lombok.Data;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用: 若Lambda体中的内容有方法已经实现了，我们可以使用"方法引用"
 * 方法引用可以理解为是Lambda表达式的另外一种表现形式
 *
 * 主要有3中语法格式
 *  - 对象::实例方法名
 *  - 类::静态方法名
 *  - 类::实例方法名
 *
 * 使用注意事项: Lambda体 和 函数式接口中抽象方法 的"参数列表返回值"需要保持一致。
 */
public class TestMethodRef {

    @Data
    static class Employee{
        private String name;

        public Employee(){

        }

        public Employee(String name){
            this.name = name;
        }
    }

    // 对象::实例方法名
    @Test
    public void test1(){
        PrintStream ps = System.out;
        Consumer<String> consumer1 = x -> ps.println(x);
        Consumer<String> consumer2 = ps::println;
        consumer1.accept("Hello");
        consumer2.accept("World");
    }

    @Test
    public void test2(){
        Employee emp = new Employee();
        emp.setName("Bob");

        Supplier<String> sup1 = () -> emp.getName();
        String str1 = sup1.get();
        System.out.println(str1);

        Supplier<String> sup2 = emp::getName;
        String str2 = sup2.get();
        System.out.println(str2);
    }

    // 类::静态方法名
    @Test
    public void test3(){
        Comparator<Integer> comparator1 = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> comparator2 = Integer::compareTo;
    }

    // 类::实例方法名
    @Test
    public void test4(){
        BiPredicate<String, String> bp1 = (x, y) -> x.equals(y);

        // 如果第一个参数是实例方法的调用者，第二个参数是实例方法的参数值，这种情况下可使用 类名::实例方法名
        BiPredicate<String, String> bp2 = String::equals;
    }

    // 构造器引用
    // 使用函数式接口的抽象方法的参数列表
    @Test
    public void test5(){
        Supplier<Employee> sup1 = () -> new Employee();

        Supplier<Employee> sup2 = Employee::new;
        Employee emp = sup2.get();
        System.out.println(emp);
    }

    @Test
    public void test6(){
        Function<String, Employee> function1 = x -> new Employee(x);

        Function<String, Employee> function2 = Employee::new;

        Employee emp = function2.apply("张三");
        System.out.println(emp);
    }

    // 数组引用
    @Test
    public void test7(){
        Function<Integer, String[]> function1 = x -> new String[x];

        Function<Integer, String[]> function2 = String[]::new;
        String[] strings = function2.apply(20);
        System.out.println(strings.length);
    }
}
