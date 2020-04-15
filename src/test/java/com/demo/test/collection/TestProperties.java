package com.demo.test.collection;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * Properties 是 Hashtable 一个子类，该对象用于处理文件
 * key 和 value 都是String类型的
 */
public class TestProperties {
    @Test
    public void test1() throws Exception {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/file/my.properties");
        prop.load(fis);
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        System.out.println(username + "=" + password);
    }
}
