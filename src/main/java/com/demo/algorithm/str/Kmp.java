package com.demo.dataStructure.str;

/**
 * KMP算法
 * <p>
 * 对于每模式串 t 的每个元素 t[i]，都存在一个实数 k
 * 使得模式串 t 开头的 k 个字符依次与 t[i] 前面的 k 个字符相同
 * 如果这样的 k 有多个，则取最大的一个。
 */
public class Kmp {
    public static void main(String[] args) {
        String s = "Hello World";
        String t = "Wo";
        System.out.println(indexOf(s, t));
    }

    /**
     * 对主串s和模式串t进行KMP模式匹配
     *
     * @param s 主串
     * @param t 模式串
     * @return 若匹配成功，返回t在s中的位置（第一个相同字符对应的位置），若匹配失败，返回-1
     */
    public static int indexOf(String s, String t) {
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        int[] next = getNextArray(t_arr);
        int i = 0, j = 0;
        while (i < s_arr.length && j < t_arr.length) {
            if (j == -1 || s_arr[i] == t_arr[j]) {
                i++;
                j++;
            } else
                j = next[j];
        }
        if (j == t_arr.length)
            return i - j;
        else
            return -1;
    }

    /**
     * 求出一个字符数组的next数组
     *
     * @param t 字符数组
     * @return next数组
     */
    private static int[] getNextArray(char[] t) {
        int[] next = new int[t.length];
        next[0] = -1;
        next[1] = 0;
        int k;
        for (int j = 2; j < t.length; j++) {
            k = next[j - 1];
            while (k != -1) {
                if (t[j - 1] == t[k]) {
                    next[j] = k + 1;
                    break;
                } else {
                    k = next[k];
                }
                next[j] = 0;  //当k==-1而跳出循环时，next[j] = 0，否则next[j]会在break之前被赋值
            }
        }
        return next;
    }
}
