package com.demo.basic;

/**
 * 调用intern()方法时，如果常量池已经存在该字符串，则直接返回字符串引用，否则复制该堆空间中字符串对象到常量池中并返回
 *
 * @author keith
 */
public class StringPool {
    public static void main(String[] args) {
        String str1 = new StringBuilder("Hello").append("World").toString();
        System.out.println(str1 == str1.intern());      // true
        System.out.println(System.identityHashCode(str1) + " " + System.identityHashCode(str1.intern()));
        // 由于java事先已存在常量池中（出厂自带）,所以str2.intern()会直接返回常量池中的字符串引用地址
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2 == str2.intern());      // false
        System.out.println(System.identityHashCode(str2) + " " + System.identityHashCode(str2.intern()));
    }
}
