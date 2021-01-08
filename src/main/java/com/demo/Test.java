package com.demo;

import java.util.Arrays;

/**
 * @author keith
 */
public class Test {
    public static void main(String[] args) {
        String a = "ab23123123||c123121||2";
        String[] split = a.split("\\|\\|");
        System.out.println(split[0]);
    }
}
