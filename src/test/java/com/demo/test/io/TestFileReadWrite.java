package com.demo.test.io;

import org.junit.Test;

import java.io.*;

/**
 * File类的获取功能
 * public String getAbsolutePath()：获取绝对路径
 * public String getPath() ：获取路径
 * public String getName() ：获取名称
 * public String getParent()：获取上层文件目录路径。若无，返回null
 * public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。  public long lastModified() ：获取最后一次的修改时间，毫秒值
 * public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
 * public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
 * <p>
 * File类的重命名功能
 * public boolean renameTo(File dest):把文件重命名为指定的文件路径
 * <p>
 * File类的判断功能
 * public boolean isDirectory()：判断是否是文件目录
 * public boolean isFile() ：判断是否是文件
 * public boolean exists() ：判断是否存在
 * public boolean canRead() ：判断是否可读
 * public boolean canWrite() ：判断是否可写
 * public boolean isHidden() ：判断是否隐藏
 * <p>
 * File类的创建功能
 * public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
 * public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。
 * 如果此文件目录的上层目录不存在，也不创建。  public boolean mkdirs() ：创建文件目录。如果上层文件目录不存在，一并创建
 * <p>
 * File类的删除功能
 * public boolean delete()：删除文件或者文件夹
 */
public class TestFileReadWrite {

    // 使用read()读取文件内容
    @Test
    public void test1() {
        // 实例化File类对象，指明要操作的文件
        File file = new File("src/main/resources/file/1.txt");
        FileReader fr = null;
        try {
            // 提供具体的流
            fr = new FileReader(file);
            // 数据的读入，read()返回读入的字符，如果到文件末尾，返回-1
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 对read()方法的升级
    @Test
    public void test2(){
        // 实例化File类对象，指明要操作的文件
        File file = new File("src/main/resources/file/1.txt");
        FileReader fr = null;
        try {
            // 提供具体的流
            fr = new FileReader(file);
            // 每次读1024个字符
            char[] cbuf = new char[1024];
            int len;
            // read(char[] cbuf) 返回每次读入cbuf数组中字符的个数，如果到达文件末尾，返回-1
            while ((len = fr.read(cbuf)) != -1){
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }
            }
            fr.read(cbuf);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 从内存中写出数据到硬盘的文件里
    // 对应File文件如果存在，则覆盖
    @Test
    public void test3() {
        File file = new File("src/main/resources/file/3.txt");
        FileWriter fw = null;
        try {
            // 参数2表示是否对原有文件追加
            fw = new FileWriter(file, false);
            fw.write("Hello World 张三");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 先读后写 -- 复制文件
    @Test
    public void test4() {
        File srcFile = new File("src/main/resources/file/3.txt");
        File dstFile = new File("src/main/resources/file/4.txt");
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(srcFile);
            fw = new FileWriter(dstFile, false);
            char[] cbuf = new char[1024];
            int len;
            while ((len = fr.read(cbuf)) != -1){
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
