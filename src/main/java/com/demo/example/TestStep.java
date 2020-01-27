package com.demo.example;

/**
 * 有n步台阶，一共有多少中走法
 */
public class TestStep {
    public static int f(int n){
        if (n < 1){
            throw new IllegalArgumentException(n + "不能小于1");
        }
        else if (n == 1 || n == 2){
            return n;
        }
        return f(n - 2) + f(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(f(50));
    }
}
