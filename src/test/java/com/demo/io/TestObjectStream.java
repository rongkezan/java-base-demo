package com.demo.io;

import org.junit.Test;

import java.io.*;

/**
 * 对象流
 * ObjectOutputStream: 序列化，保存基本类型数据或对象的机制
 * ObjectInputStream: 反序列化，读取基本类型数据或对象的机制
 *
 * 不能序列化static和transient修饰的成员变量
 */
public class TestObjectStream {
    /**
     * 序列化过程: 将内存中的java对象保存到磁盘中或通过网络传输出去
     */
    @Test
    public void testSerializable(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/file/object.dat"));
            oos.writeObject(new String("我爱北京天安门"));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 反序列化过程: 将磁盘中的数据转换为对象
     */
    @Test
    public void testDeserialize(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("src/main/resources/file/object.dat"));
            Object obj = ois.readObject();
            System.out.println(obj);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
