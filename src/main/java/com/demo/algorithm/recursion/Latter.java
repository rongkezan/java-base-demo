package com.demo.algorithm.recursion;

/**
 * 假设一个楼梯有 N 阶台阶，人每次最多可以跨 M 阶，求总共的爬楼梯方案数。
 * 例如楼梯总共有3个台阶，人每次最多跨2个台阶，也就是说人每次可以走1个，也可以走2个，但最多不会超过2个，那么楼梯总共有这么几种走法
 *
 * 使用递归: 递归累加跳跃的次数直到 阶梯的数量变成0
 * 简单来说，阶梯数被减为0即为一种走法
 *
 * @author keith
 */
public class Latter {

    public static void main(String[] args) {
        int ladder = 3;
        int maxJump = 2;
        int i = calculateCount(ladder, maxJump);
        System.out.println(i);
    }

    private static int calculateCount(int ladder, int maxJump) {
        int jumpWay = 0;
        if (ladder == 0) {
            return 1;
        }
        if (ladder >= maxJump) {
            // 剩下的楼梯大于最大可跳跃数
            for (int i = 1; i <= maxJump; i++) {
                jumpWay += calculateCount(ladder - i, maxJump);
            }
        } else {
            // 剩下的楼梯不足最大可跳跃数
            jumpWay = calculateCount(ladder, ladder);
        }
        return jumpWay;
    }
}
