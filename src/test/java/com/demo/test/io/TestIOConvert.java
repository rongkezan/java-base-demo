package com.demo.test.io;

import org.junit.Test;

import java.io.*;

/**
 * 转换流: 提供字节流与字符流之间的转换
 * InputStreamReader: 将一个字节的输入流转换为字符的输入流
 * OutputStreamWriter: 将一个字符的输出流转换为字节的输入流
 *
 * 解码: 字节、字节数组 --> 字符数组、字符串
 * 编码: 字符数组、字符串 --> 字节、字节数组
 */
public class TestIOConvert {

    // 读转换流
    @Test
    public void test1() {
        InputStreamReader isr = null;
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/file/1.txt");
            // 参数2指明字符集，具体使用哪个字符集取决于txt文件保存时使用哪个字符集
            isr = new InputStreamReader(fis, "UTF-8");
            char[] cbuf = new char[20];
            int len;
            while ((len = isr.read(cbuf)) != -1){
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 综合使用InputStreamReader和OutputStreamReader
    // 先解码UTF-8文件，再编码为GBK文件
    @Test
    public void test2(){
        File srcFile = new File("src/main/resources/file/1.txt");
        File dstFile = new File("src/main/resources/file/1-rep.txt");

        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(dstFile);

            isr = new InputStreamReader(fis, "UTF-8");
            osw = new OutputStreamWriter(fos, "GBK");

            char[] cbuf = new char[20];
            int len;
            while ((len = isr.read(cbuf)) != -1){
                osw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
