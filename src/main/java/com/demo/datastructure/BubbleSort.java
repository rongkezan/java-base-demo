package com.demo.datastructure;

/**
 * 冒泡排序
 *  时间复杂度 O(n²)
 *  空间复杂度 O(1)
 *
 * 算法步骤:
 *  1. 比较相邻的元素，如果第一个比第二个大，就交换
 *  2. 每一对元素都做同样的工作，重复操作
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 7, 9, 1, 3, 8, 4, 6 };
        int i, j, temp;
        for(i = 0; i < arr.length - 1; i++){
            for(j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int res : arr) {
            System.out.print(res + "\t");
        }
    }
}
