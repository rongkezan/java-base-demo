package com.demo.algorithm.recursion;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 用1元,2元,5元 组成n元的所有方法
 *
 * 使用双层循环
 * 外层循环是5元的，循环次数是 sum / 5 ，如有100元最多循环20次
 * 内层循环是2元的，循环次数是 sum - 5 * i，即循环的次数与5元的张数有关
 * 剩余的都是1元，即 1元 = sum - 5 * i - 2 * j
 *
 * @author keith
 */
public class Money {
    public static void main(String[] args) {
        List<Group> groups = fun(100);
        groups.forEach(e -> System.out.println(e.one + " " + e.two + " " + e.five));
    }

    public static List<Group> fun(Integer sum) {
        List<Group> list = new ArrayList<>();
        for (int i = 0; i < sum / 5; i++) {
            for (int j = 0; j <= (sum - 5 * i) / 2; j++) {
                int k = sum - 5 * i - 2 * j;
                list.add(new Group(i, j, k));
            }
        }
        return list;
    }

    @AllArgsConstructor
    private static class Group{
        public int one;
        public int two;
        public int five;
    }
}
