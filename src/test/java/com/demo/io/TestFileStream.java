package com.demo.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileInputStream
 * FileOutputStream
 *
 * 对于文本文件(txt, java, c, cpp)，使用字符流处理
 * 对于非文本文件(jpg, mp3, mp4, doc, ppt)，使用字节流处理
 */
public class TestFileStream {

    // 读取文件字节流
    @Test
    public void test1(){
        File file = new File("src/main/resources/img/1.jpg");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while ((len = fis.read(buf)) != -1){
                String str = new String(buf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 复制图片
    @Test
    public void test2(){
        File srcFile = new File("src/main/resources/img/1.jpg");
        File dstFile = new File("src/main/resources/img/2.jpg");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(dstFile);
            byte[] buf = new byte[1024];
            int len;
            while ((len = fis.read(buf)) != -1){
                fos.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
