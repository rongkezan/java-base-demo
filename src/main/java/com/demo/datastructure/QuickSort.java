package com.demo.datastructure;

/**
 * 快速排序: 给基准数据找其正确索引位置
 *  时间复杂度: O(nlogn) ~ O(n²)
 *  空间复杂度: O(logn) ~ O(n)
 *
 *
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 7, 9, 1, 3, 8, 4, 6, 0 };
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }

    private static void quickSort(int[] arr, int low, int high){
        if(low > high) return;
        int i = low, j = high, temp, t;
        temp = arr[low];    //基准位
        while (i < j) {
            while (temp <= arr[j] && i < j) j--;                    // 先看右边，依次往左递减
            while (temp >= arr[i] && i < j) i++;                    // 再看左边，依次往右递增
            if (i < j) { t = arr[j]; arr[j] = arr[i]; arr[i] = t; } // 如果满足条件则交换
        }
        arr[low] = arr[i]; arr[i] = temp;                           // 最后将基准位与i和j相等位置的数字交换
        quickSort(arr, low, j - 1);                           // 递归调用左半数组
        quickSort(arr, j + 1, high);                           // 递归调用右半数组
    }
}
