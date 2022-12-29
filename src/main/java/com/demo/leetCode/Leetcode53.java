package com.demo.leetCode;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class Leetcode53 {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, -1, 7, 8};
        int res = maxSubArray(nums);
        System.out.println(res);
    }

    public static int maxSubArray(int[] nums) {
        // 状态转移方程式: f[i]是最大子序列之和
        // f[0] = max( 0    + nums[0], nums[0] )
        // f[1] = max( f[0] + nums[1], nums[1] )
        // f[2] = max( f[1] + nums[2], nums[2] )
        // ...
        // f[i] = max( f[i - 1] + nums[i], nums[i] )

        int[] f = new int[nums.length];
        f[0] = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(f[i], maxSum);
        }
        return maxSum;
    }
}
