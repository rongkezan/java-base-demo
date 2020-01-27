package com.demo.example;

import java.util.concurrent.Executors;

public class Exam2 {
    static int s;
    int i;
    int j;
    {
        int i = 1;
        i ++;
        j ++;
        s ++;
    }

    public void test(int j){
        j ++;
        i ++;
        s ++;
    }

    public static void main(String[] args) {
        Exam2 ex1 = new Exam2();
        Exam2 ex2 = new Exam2();
        ex1.test(10);
        ex1.test(20);
        ex2.test(30);
        System.out.println(ex1.i + "," + ex1.j + "," + ex2.s);
        System.out.println(ex2.i + "," + ex2.j + "," + ex2.s);
    }
}
