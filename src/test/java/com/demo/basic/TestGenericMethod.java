package com.demo.basic;

import java.util.Arrays;
import java.util.List;

/**
 * 泛型方法: 在方法中出现了泛型结构，泛型参数和类的泛型参数没有任何关系
 */

class Order<E>{
    // public <E> 中的 <E> 表示告诉编译器不是有个类叫 E，而是有个泛型参数E
    // 可以声明静态泛型方法
    public <E> List<E> copyFromArrayToList(E[] arr){
        return Arrays.asList(arr);
    }

    public static <E> List<E> copyFromArrayToListStatic(E[] arr){
        return Arrays.asList(arr);
    }
}

public class TestGenericMethod {
    public static void main(String[] args) {
        Order<String> order = new Order<>();
        List<Integer> list = order.copyFromArrayToList(new Integer[]{1, 2, 3});
        System.out.println(list.getClass());
        System.out.println(list);
    }
}
