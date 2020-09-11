package com.demo;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String path = "E:\\Zjport\\报文\\原始资料\\20200902联邦易豹编号";
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
