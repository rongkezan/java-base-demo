package com.demo.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 转换流: 提供字节流与字符流之间的转换
 * InputStreamReader: 将一个字节的输入流转换为字符的输入流
 * OutputStreamWriter: 将一个字符的输出流转换为字节的输入流
 *
 * 解码: 字节、字节数组 --> 字符数组、字符串
 * 编码: 字符数组、字符串 --> 字节、字节数组
 */
public class TestIOConvert {
    @Test
    public void test1() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("src/main/resources/file/1.txt");

    }
}
