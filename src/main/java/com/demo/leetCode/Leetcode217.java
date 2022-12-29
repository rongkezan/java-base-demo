package com.demo.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 */
public class Leetcode217 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        boolean res = containsDuplicate(nums);
        System.out.println(res);
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() != nums.length;
    }
}
