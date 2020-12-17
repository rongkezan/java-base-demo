package com.demo.basic;

/**
 * @author keith
 */
public class StringPool {
    public static void main(String[] args) {
        String str1 = new StringBuilder("Hello").append("World").toString();
        System.out.println(str1 == str1.intern());      // true
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2 == str2.intern());      // false
    }
}
