package com.demo.test.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.*;

/**
 * Set: store unordered and unrepeatable data
 * <p>
 * - HashSet: Thread not safe, can store null value
 * - Linked HashSet: it's sequence when you iterate data in Linked HashSet
 * - Linked HashSet: 遍历其内部数据时，可以按照添加的顺序遍历
 * - TreeSet: order by specify attribute
 * <p>
 * 添加过程: 以HashSet为例
 * 1. 向HashSet添加元素a，首先调用a的hashCode()计算a的Hash值
 * 2. 此Hash值通过某种算法计算出在HashSet底层数组中存放的位置(索引位置)
 * - if (没有其他元素) a元素添加成功
 * - if (有其它元素) 比较a和此链表上所有元素的Hash值
 * - if (相同) 调用equals()判断相同添加失败
 * - else a元素添加成功
 */

public class TestSet {
    @AllArgsConstructor
    @Data
    static class User implements Comparable {
        private String name;
        private int age;

        // 先按照姓名从小到大排列，在按照年龄从小到大排列
        @Override
        public int compareTo(Object o) {
            if (o instanceof User) {
                User user = (User) o;
                int compare = this.name.compareTo(user.name);
                if (compare != 0){
                    return compare;
                } else{
                    return Integer.compare(this.age, user.getAge());
                }
            } else{
                throw new RuntimeException("输入类型不匹配");
            }
        }
    }

    @Test
    public void test1() {
        System.out.println("123".hashCode());
        System.out.println("123".hashCode());
        System.out.println(new Integer(123).hashCode());
    }

    // LinkedHashSet作为HashSet的子类，添加数据的同时每个数据还维护了两个引用记录前一个数据和后一个数据
    @Test
    public void test2() {
        Set set = new LinkedHashSet();
        set.add("hello");
        set.add("world");
        set.add(123);
        set.add(new int[]{1, 2, 3, 4});
        System.out.println(set);
    }

    /**
     * 向TreeSet中添加的数据，要求是相同类的对象
     * 会自动排序
     */
    @Test
    public void test3() {
        Set<String> set = new TreeSet();
        set.add("hello");
        set.add("world");
        set.add("yo");
        set.add("tree");
        System.out.println(set);
    }

    /**
     * TreeSet判断元素是否相等根据CompareTo的返回值，如果返回0认为一样
     */
    @Test
    public void test4() {
        Set set = new TreeSet();
        set.add(new User("AA", 33));
        set.add(new User("CC", 23));
        set.add(new User("DD", 44));
        set.add(new User("ZZ", 1));
        set.add(new User("FF", 2));
        System.out.println(set);
    }

    /**
     * TreeSet中传一个Comparator参数，用Comparator中的规则比较
     */
    @Test
    public void test5(){
        Comparator com = new Comparator() {
            // 按照年龄从小到大排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                } else{
                    throw new RuntimeException("输入的数据类型不匹配");
                }
            }
        };
        Set set = new TreeSet(com);
        set.add(new User("AA", 33));
        set.add(new User("CC", 23));
        set.add(new User("DD", 44));
        set.add(new User("ZZ", 1));
        set.add(new User("FF", 2));
        System.out.println(set);
    }
}
