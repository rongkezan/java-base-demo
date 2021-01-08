package com.demo.collection.map;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Properties 是 Hashtable 一个子类，该对象用于处理文件
 * key 和 value 都是String类型的
 */
public class PropertiesDemo {

    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/file/my.properties");
        prop.load(fis);
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        System.out.println(username + "=" + password);
    }
}
