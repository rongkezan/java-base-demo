package com.demo.test.io;

import org.junit.Test;

import java.io.*;

/**
 * 缓冲流: 提高流的读取写入速度
 */
public class TestBuffered {
    // 复制图片
    @Test
    public void test1() {
        File srcFile = new File("src/main/resources/img/1.jpg");
        File dstFile = new File("src/main/resources/img/2.jpg");
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // 创建节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(dstFile);
            // 创建缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            // 读取写入
            byte[] buf = new byte[1024];
            int len;
            while ((len = bis.read(buf)) != -1) {
                bos.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 资源关闭，关闭外层流的同时，内层流也会自动关闭
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 复制文本文件
    @Test
    public void test2() {
        File srcFile = new File("src/main/resources/file/1.txt");
        File dstFile = new File("src/main/resources/file/5.txt");
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            // 创建节点流
            FileReader fr = new FileReader(srcFile);
            FileWriter fw = new FileWriter(dstFile);
            // 创建缓冲流
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            // 读取写入
            char[] cbuf = new char[1024];
            int len;
            while ((len = br.read(cbuf)) != -1) {
                bw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 资源关闭，关闭外层流的同时，内层流也会自动关闭
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 复制文本文件 方式2
    @Test
    public void test3() {
        File srcFile = new File("src/main/resources/file/1.txt");
        File dstFile = new File("src/main/resources/file/5.txt");
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            // 创建节点流
            FileReader fr = new FileReader(srcFile);
            FileWriter fw = new FileWriter(dstFile);
            // 创建缓冲流
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            // 读取写入
            String data;
            while ((data = br.readLine()) != null) {
                bw.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 资源关闭，关闭外层流的同时，内层流也会自动关闭
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}