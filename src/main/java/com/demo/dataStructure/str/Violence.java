package com.demo.dataStructure.str;

/**
 * 暴力匹配
 *
 * @author keith
 */
public class Violence {
    public static void main(String[] args) {
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
