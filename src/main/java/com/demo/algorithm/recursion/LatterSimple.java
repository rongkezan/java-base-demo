package com.demo.algorithm.recursion;

/**
 * 假设一个楼梯有 N 阶台阶，人每次最多可以跨 2 阶，求总共的爬楼梯方案数，要求不用递归实现
 *
 * 斐波那契数列 : f(n) = f(n-1) + f(n-2)
 * @author keith
 */
public class LatterSimple {

    public static void main(String[] args) {
        int i = 9;
        System.out.println(count(i));
    }

    private static int count(int ladder) {
        if (ladder == 1 || ladder == 2) {
            return ladder;
        }
        int n1 = 1;
        int n2 = 2;
        for (int i = 3; i <= ladder; i++) {
            int tmp = n2;
            n2 = n1 + n2;
            n1 = tmp;
        }
        return n2;
    }
}
