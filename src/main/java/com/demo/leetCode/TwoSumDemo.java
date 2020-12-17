package com.demo.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author keith
 */
public class TwoSumDemo {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] resArr = twoSum1(nums, 9);
        if (resArr == null){
            System.out.println("no match result");
            return;
        }
        System.out.println(resArr[0] + " " + resArr[1]);
    }

    /* T(n) = O(n²) ; S(n) = O(n) */
    public static int[] twoSum1(int[] nums, int target){
        for (int i = 0; i < nums.length; i++){
            for (int j = i; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /* T(n) = O(n) ; S(n) = O(n²) */
    public static int[] twoSum2(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int anotherNum = target - nums[i];
            if (map.containsKey(anotherNum)){
                return new int[]{map.get(anotherNum), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
