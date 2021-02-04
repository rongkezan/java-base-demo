package com.demo.algorithm.sort;

/**
 * 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 7, 9, 1, 3, 8, 4, 6, 0 };
        int length = arr.length;
        int minIdx, temp;

        for (int i = 0; i < length - 1; i++){
            minIdx = i;
            for (int j = i + 1; j < length; j++){
                if (arr[j] < arr[minIdx]){
                    minIdx = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }

        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }
}
