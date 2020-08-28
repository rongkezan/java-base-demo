package com.demo.design.pattern.strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorClient {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.sort(Comparator.comparingInt(o -> o));
        System.out.println(list);
    }
}
