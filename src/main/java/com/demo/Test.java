package com.demo;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String path = "E:\\Zjport\\报文\\原始资料\\8.18海陆空易豹编号264份（8.13-8.14）\\8.16联邦空运非规范36份";
        File file = new File(path);
        File[] fs = file.listFiles();
        for (File f : fs) {
            int i = f.getName().indexOf("20200");
            String name = f.getName().substring(i, i + 13);
            System.out.print(name + ",");
        }
        System.out.println(sb.toString());
    }
}
