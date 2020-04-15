package com.demo.test.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java8 内置的四大核心函数式接口
 * Consumer<T>: 消费型接口
 *  void accept(T t);
 * Supplier<T>: 供给型接口
 *  T get();
 * Function<T, R>: 函数型接口
 *  R apply(T t)
 * Predicate<T>: 断言型接口
 *  boolean test(T t)
 */
public class TestLambda {

    // 消费型接口
    @Test
    public void testConsumer(){
        happy(1000, m -> System.out.println("消费金额:" + m));
    }

    public void happy(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }

    // 供给型接口
    @Test
    public void testSupplier(){
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        for(Integer integer : numList){
            System.out.println(integer);
        }
    }

    // 需求: 产生指定个数的整数并放入集合中
    public List<Integer> getNumList(int count, Supplier<Integer> supplier){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < count; i++){
            Integer integer = supplier.get();
            list.add(integer);
        }
        return list;
    }

    // 函数型接口
    @Test
    public void testFunction(){
        String newStr1 = strHandler("\t\t\t Hello World    ", (str) -> str.trim());
        System.out.println(newStr1);

        String newStr2 = strHandler("Hello World", str -> str.substring(0, 2));
        System.out.println(newStr2);
    }

    // 需求: 用于处理字符串
    public String strHandler(String str, Function<String, String> function){
        return function.apply(str);
    }

    // 断言型接口
    @Test
    public void testPredicate(){
        List<String> list = Arrays.asList("Hello", "World", "Yop", "你好吗", "诗和远方");
        List<String> strList = filterStr(list, str -> str.length() > 3);
        for(String str : strList){
            System.out.println(str);
        }
    }

    // 需求: 将满足条件的字符串添加到集合中
    public List<String> filterStr(List<String> list, Predicate<String> predicate){
        List<String> strList = new ArrayList<>();
        for(String str : list){
            if(predicate.test(str)){
                strList.add(str);
            }
        }
        return strList;
    }
}
