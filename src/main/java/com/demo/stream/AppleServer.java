package com.demo.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AppleServer {

    @Data
    @AllArgsConstructor
    public static class Apple {

        private int id;

        private String color;

        private int weight;
    }

    private static List<Apple> APPLES = new ArrayList<>();

    static {
        APPLES.add(new Apple(1, "red", 500));
        APPLES.add(new Apple(2, "red", 400));
        APPLES.add(new Apple(3, "green", 600));
        APPLES.add(new Apple(4, "green", 400));
        APPLES.add(new Apple(5, "green", 300));
    }

    public static void main(String[] args) {
        // 找出红色且重量>=450的苹果
        List<Apple> filterApples = APPLES.stream()
                .filter(a -> a.getColor().equals("red"))
                .filter(a -> a.getWeight() >= 450)
                .collect(Collectors.toList());
        System.out.println(filterApples);

        // 求出每个颜色的平均重量
        Map<String, Double> avgApples = APPLES.stream()
                .collect(Collectors.groupingBy(Apple::getColor, Collectors.averagingInt(Apple::getWeight)));
        System.out.println(avgApples);

        // 求出每个颜色的总重量
        Map<String, Integer> summingApples = APPLES.stream()
                .collect(Collectors.groupingBy(Apple::getColor, Collectors.summingInt(Apple::getWeight)));
        System.out.println(summingApples);
    }
}
