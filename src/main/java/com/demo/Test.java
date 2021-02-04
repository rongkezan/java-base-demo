package com.demo;

import com.demo.collection.entity.CollectionUser;
import com.demo.design.pattern.builder.User;

/**
 * @author keith
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String s = "Hello World";
        String t = "Wo";
        System.out.println(indexOf(s, t));
    }

    public static int indexOf(String str, String subStr) {
        char[] s = str.toCharArray();
        char[] t = subStr.toCharArray();
        int i = 0, j = 0;
        while (i < s.length && j < t.length) {
            if (s[i] == t[j]) {
                i++;
                j++;
            } else {
                i = i - (j - 1);
                j = 0;
            }
        }
        if (j == t.length)
            return (i - j);     //主串中存在该模式返回下标号
        else
            return -1;          //主串中不存在该模式
    }
}
