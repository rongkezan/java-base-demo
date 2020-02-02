package com.demo.io;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile: 既可以作为输入流又可以作为输出流
 * mode参数:
 * 1. r   以只读的方式打开
 * 2. rw  打开以便读取写入
 * 3. rwd 打开以便读取写入，同步文件内容的更新
 * 4. rws 打开以便读取写入，同步文件内容和元数据更新
 */
public class TestRandomAccessFile {
    @Test
    public void test1(){
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile("src/main/resources/file/1.txt", "r");
            raf2 = new RandomAccessFile("src/main/resources/file/11.txt", "rw");
            byte[] buf = new byte[1024];
            int len;
            while ((len = raf1.read(buf)) != -1){
                raf2.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf1 != null)
                    raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (raf2 != null)
                    raf2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 不是对原有文件进行覆盖，而是对文件内容进行覆盖
    @Test
    public void test2() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("src/main/resources/file/hello.txt", "rw");
        raf.seek(3);    // 将指针调到角标为3的位置
        raf.write("aaa".getBytes());
        raf.close();
    }
}
