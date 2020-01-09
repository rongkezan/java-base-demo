package com.demo.java8;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 引用方法
 *  对象引用::实例方法名
 *  objectReference::functionName
 *  类名::静态方法名
 *  className::staticFunctionName
 *  类名::实例方法名
 *  className:functionName
 */
public class FunctionReferenceDemo {
    public static void main(String[] args) {
        // 对象引用::实例方法名
        Consumer<String> consumer = System.out::println;
        consumer.accept("Hello World");

        // 类名::静态方法名
        Function<Long, Long> f1 = x -> Math.abs(x);
        Function<Long, Long> f2 = Math::abs;
        System.out.println(f1.apply(-3L));
        System.out.println(f2.apply(-3L));

        // 类名::实例方法名
        BiPredicate<String, String> b1 = (x, y) -> x.equals(y);
        BiPredicate<String, String> b2 = String::equals;
        System.out.println(b1.test("aaa", "aaa"));
        System.out.println(b2.test("aaa", "aaa"));

        // 引用构造器
        Function<Integer, StringBuffer> fun1 = n -> new StringBuffer(n);
        Function<Integer, StringBuffer> fun2 = StringBuffer::new;
        StringBuffer buf1 = fun1.apply(10);
        StringBuffer buf2 = fun2.apply(10);
        System.out.println(buf1.toString());
        System.out.println(buf2);
    }
}
