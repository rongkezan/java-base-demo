package com.demo.algorithm.recursion;

/**
 * 通过递归处理阶乘问题
 */
public class FactorialDemo {
    public static void main(String[] args) {
        System.out.println(factorial(2));
    }

    public static int factorial(int n){
        if (n == 1){
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
}
