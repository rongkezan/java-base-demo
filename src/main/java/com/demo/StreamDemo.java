package com.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
//        Stream.generate(Math::random).limit(5).forEach(System.out::println);
        List<Integer> list = Stream.iterate(0, i -> i + 1).limit(5).collect(Collectors.toList());
        list.forEach((Integer x) -> System.out.println(x));

        
    }
}
