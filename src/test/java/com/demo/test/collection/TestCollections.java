package com.demo.test.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Collections 工具类
 *
 * 排序操作
 * - reverse(List)              反转List元素顺序
 * - shuffle(List)              对List元素进行随机排序
 * - sort(List)                 根据元素的自然顺序对List进行升序排序
 * - sort(List, Comparator)     根据指定的Comparator对List进行排序
 * - swap(List, int, int)       将List中的i处元素和j处元素交换
 *
 * 查找、替换
 * - Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
 * - Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
 * - Object min(Collection)
 * - Object min(Collection，Comparator)
 * - int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
 * - void copy(List dest,List src)：将src中的内容复制到dest中
 * - boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换List 对象的所有旧值
 */
public class TestCollections {
    List<String> list = null;

    @Before
    public void init(){
        list = new ArrayList<>();
        list.add("abc");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("fff");
        list.add("mvnx");
        list.add("张三");
    }
    @Test
    public void test1(){
        Collections.reverse(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, (o1, o2) -> -o1.compareTo(o2));
        System.out.println(list);
        Collections.swap(list, 1, 2);
        System.out.println(list);
    }

    @Test
    public void test2(){
        int frequency = Collections.frequency(list, "123");
        System.out.println(frequency);
    }

    @Test
    public void test3(){
        //报异常 IndexOutOfBoundsException("Source does not fit in dest");
        //List<String> dest = new ArrayList<>(list.size() + 1);
        List<String> dest = Arrays.asList(new String[list.size()]);
        Collections.copy(dest, list);
        System.out.println(dest);
    }
}
