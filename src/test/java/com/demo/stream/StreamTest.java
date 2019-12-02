package com.demo.stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Java8 新特性：流式数据处理
 */
public class StreamTest {

    private List<Integer> nums = new ArrayList<>();

    private List<Integer> list = new ArrayList<>();

    private Set<Integer> set = new HashSet<>();

    private Map<Integer, String> map = new HashMap<>();

    @Before
    public void init(){
        for(int i = 0; i < 10; i++){
            nums.add(i);
        }
    }

    /**
     * stream()操作将集合转换成一个流
     * filter()执行我们自定义的筛选处理
     * 最后通过collect()对结果进行封装处理，并通过Collectors.toList()指定其封装成为一个List集合返回。
     */
    @Test
    public void testToList(){
        for(Integer num : nums){
            if(num % 2 == 0){
                list.add(num);
            }
        }
        for(Integer even : list){
            System.out.print(even + "\t");
        }
    }

    @Test
    public void testToListStream(){
        list = nums.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        for(Integer even : list){
            System.out.print(even + "\t");
        }
    }

    @Test
    public void testToSetStream(){
        for(int i = 0; i < 18; i++){
            nums.add(i);
        }
        set = nums.stream().filter(num -> num % 2 == 0).collect(Collectors.toSet());
        for(Integer i : set){
            System.out.print(i + "\t");
        }
    }
}
