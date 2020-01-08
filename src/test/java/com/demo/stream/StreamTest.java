package com.demo.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 中间操作：
 *  filter()：  对元素进行过滤
 *  sorted()：  对元素排序
 *  map()：     元素映射
 *  distinct()：去除重复的元素
 *
 * 最终操作：
 *  forEach()： 遍历每个元素。
 *  reduce()：  把Stream元素组合起来。例如，字符串拼接，数值的 sum，min，max ，average 都是特殊的 reduce。
 *  collect()： 返回一个新的集合。
 *  min()：     找到最小值。
 *  max()：     找到最大值。
 */
public class StreamTest {

    private List<Integer> list = new ArrayList<>();

    @Before
    public void init(){
        for(int i = 0; i < 2; i++)
            for(int j = 0; j < 10; j++)
                list.add(j);
    }

    @Test
    public void testFilter(){
        System.out.println("---- 根据给定的条件对集合数据过滤 ----");
        list.stream().filter(p -> p >= 5).forEach(System.out::println);
    }

    @Test
    public void testSorted(){
        System.out.println("---- 对集合数据进行排序，默认升序 ----");
        list.stream().sorted().forEach(System.out::println);
    }

    @Test
    public void testMap(){
        System.out.println("---- 对于集合中每个元素可以按照规则变成相应元素 ----");
        list.stream().map(p -> p >=5 ? 10 : p).forEach(System.out::println);
    }

    @Test
    public void testDistinct(){
        System.out.println("---- 给集合去重 ----");
        list.stream().distinct().forEach(System.out::println);
    }

    @Test
    public void testReduce(){
        System.out.println("---- 把集合里的数据组合起来 ----");
        System.out.println(list.stream().reduce((p1, p2) -> p1 + p2).get());
    }

    @Test
    public void testCollect(){
        System.out.println("---- 把原先集合的数据经过操作返回一个新的集合 ----");
        Set<Integer> set = list.stream().collect(Collectors.toSet());
        set.forEach(System.out::println);
    }

    @Test
    public void testMax(){
        System.out.println("---- 取出集合中最大值 ----");
        System.out.println(list.stream().max(Comparator.comparing(Integer::valueOf)).get());
    }

    @Test
    public void testMin(){
        System.out.println("---- 取出集合中最小值 ----");
        System.out.println(list.stream().min(Comparator.comparing(Integer::valueOf)).get());
    }
}
