package com.demo.designPattern.pattern.singleton;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Singleton3 {
    public static final Singleton3 INSTANCE;
    private String info;

    static {
        Properties pro = new Properties();
        try {
            FileInputStream fis = new FileInputStream("E:\\Workspace\\Idea\\java-base-demo\\src\\main\\resources\\file\\my.properties");
            pro.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        INSTANCE = new Singleton3(pro.getProperty("info"));
    }

    private Singleton3(String info){
        this.info = info;
    }

    @Override
    public String toString() {
        return "Singleton3{" +
                "info='" + info + '\'' +
                '}';
    }
}
