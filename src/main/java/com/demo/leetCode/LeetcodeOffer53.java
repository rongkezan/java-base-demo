package com.demo.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * <p>
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetcodeOffer53 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 3};
        int i = missingNumber(nums);
        System.out.println(i);
    }

    public static int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
}
