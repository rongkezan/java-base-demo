package com.demo.test.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream的三个操作步骤
 * 1. 创建Stream
 * 2. 中间操作
 * 3. 终止操作(终端操作)
 */
public class TestStreamCreate {

    //创建Stream
    @Test
    public void test1(){
        // 1. 可以通过 Collection 提供的 stream() 或 parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        // 2. 通过 Arrays 中的静态方法 stream() 获取数组流
        Integer[] intArr = new Integer[30];
        Stream<Integer> stream2 = Arrays.stream(intArr);

        // 3. 通过Stream类中的静态方法of()
        Stream<String> stream3 = Stream.of("a", "b", "c");

        // 4. 创建无限流
        // 迭代
        Stream<Integer> stream4 = Stream.iterate(0, x -> x + 2);
        stream4.forEach(System.out::println);
        // 生成
        Stream.generate(() -> Math.random())
                .forEach(System.out::println);
        //使用limit截断
        Stream.generate(() -> Math.random())
                .limit(5)
                .forEach(System.out::println);
    }
}
