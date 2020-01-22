package com.demo.basic;

import org.junit.Test;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Properties 用来读取配置文件
 */
public class TestProperties {
    @Test
    public void test() throws Exception {
        Properties pros = new Properties();
        FileInputStream fis = new FileInputStream("E:\\Workspace\\Idea\\java-base-demo\\src\\main\\resources\\file\\my.properties");
        pros.load(fis);
        String username = pros.getProperty("username");
        String password = pros.getProperty("password");
        System.out.println("username = "+  username + ",password = " + password);
    }
}
