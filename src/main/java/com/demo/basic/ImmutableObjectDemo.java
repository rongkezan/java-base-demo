package com.demo.basic;

import java.util.Arrays;

/**
 * 传参是基本数据类型:
 * 传递数据值
 *
 * 传参是引用数据类型
 * - 传递地址值
 * - 特殊的类型: String、包装类等对象不可变性
 *
 * 《Effective Java》
 * 不可变对象(Immutable Object)：对象一旦被创建后，对象所有的状态及属性在其生命周期内不会发生任何变化。
 * 由于ImmutableObject不提供任何setter方法，并且成员变量value是基本数据类型，getter方法返回的是value的拷贝
 * 所以一旦ImmutableObject实例被创建后，该实例的状态无法再进行更改，因此该类具备不可变性。
 */
public class ImmutableObjectDemo {

    static class MyData{
        int a = 10;
    }

    static void change(int j, String s, Integer n, int[] a, MyData m){
        j += 1;
        s += "world";
        n += 1;
        a[0] += 1;
        m.a += 1;
    }

    public static void main(String[] args) {
        int i = 1;
        String str = "hello";
        Integer num = 2;
        int[] arr = {1,2,3,4,5};
        MyData myData = new MyData();

        change(i, str, num, arr, myData);

        System.out.println("i = " + i);
        System.out.println("str = " + str);
        System.out.println("num = " + num);
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("myData.a = " + myData.a);
    }
}
