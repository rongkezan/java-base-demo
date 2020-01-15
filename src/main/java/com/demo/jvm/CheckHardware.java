package com.demo.jvm;

public class CheckHardware {
    public static void main(String[] args) {
        System.out.println("--- Cpu的核数 ---");
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
