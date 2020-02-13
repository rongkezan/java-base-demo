package com.demo.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 1. 缓冲区(Buffer): 在Java Nio中负责数据的存取，缓冲区就是数组，用于存储不同类型的数据
 *
 * 2. 缓冲区有以下几种类型
 * - ByteBuffer (常用)
 * - CharBuffer
 * - ShortBuffer
 * - IntBuffer
 * - LongBuffer
 * - FloatBuffer
 * - DoubleBuffer
 *
 * 上述缓冲区的管理方式几乎一致，通过 allocate() 获取缓冲区
 *
 * 3. 缓冲区存取数据的两个核心方法
 * - put()  存入数据到缓冲区中
 * - get()  获取数据从缓冲区中
 *
 * 4. 缓冲区中的4个核心属性
 * - capacity   容量，表示缓冲区中最大存储数据的容量，一旦声明不能改变。
 * - limit      界限，表示缓冲区中可以操作数据的大小。(limit后数据不能读写)
 * - position   位置，表示缓冲区中正在操作数据的位置。
 * - mark       标记，表示记录当前position的位置，可以通过reset()恢复到mark的位置
 * 需要满足 0 <= mark <= position <= limit <= capacity
 */
public class TestBuffer {

    @Test
    public void test1(){
        String str = "Hello World";
        // 1. 分配一个指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        System.out.println("---------- allocate() ---------------");
        System.out.println("position\t" + buf.position());  // 0
        System.out.println("limit\t" + buf.limit());        // 1024
        System.out.println("capacity\t" + buf.capacity());  // 1024

        // 2. 利用put()存入数据到缓冲区中
        buf.put(str.getBytes());
        System.out.println("---------- put() ---------------");
        System.out.println("position\t" + buf.position());  // 11
        System.out.println("limit\t" + buf.limit());        // 1024
        System.out.println("capacity\t" + buf.capacity());  // 1024

        // 3. 切换成读取数据的模式 position归0
        buf.flip();
        System.out.println("---------- flip() ---------------");
        System.out.println("position\t" + buf.position());  // 0
        System.out.println("limit\t" + buf.limit());        // 11
        System.out.println("capacity\t" + buf.capacity());  // 1024

        // 4. 利用get()读取缓冲区中的数据
        byte[] dst = new byte[buf.limit()];
        buf.get(dst);
        System.out.println(new String(dst, 0, dst.length));
        System.out.println("---------- get() ---------------");
        System.out.println("position\t" + buf.position());  // 11
        System.out.println("limit\t" + buf.limit());        // 11
        System.out.println("capacity\t" + buf.capacity());  // 1024

        // 5. rewind() 可重复读
        buf.rewind();
        System.out.println("---------- rewind() ---------------");
        System.out.println("position\t" + buf.position());  // 0
        System.out.println("limit\t" + buf.limit());        // 11
        System.out.println("capacity\t" + buf.capacity());  // 1024

        // 6. clear() 清空缓冲区，但是缓冲区的数据依然存在，但是处于"被遗忘"状态
        buf.clear();
        System.out.println("---------- clear() ---------------");
        System.out.println("position\t" + buf.position());  // 0
        System.out.println("limit\t" + buf.limit());        // 11
        System.out.println("capacity\t" + buf.capacity());  // 1024
    }

    @Test
    public void testMark(){
        String str = "Hello World";
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put(str.getBytes());
        buf.flip();
        byte[] dst = new byte[buf.limit()];
        buf.get(dst, 0, 2);
        System.out.println(new String(dst, 0, 2));
        System.out.println(buf.position()); // 2
        buf.mark();     // 标记当前的位置
        buf.get(dst, 2, 2);
        System.out.println(new String(dst, 2, 2));
        System.out.println(buf.position()); // 4
        buf.reset();    // 恢复到mark的位置
        System.out.println(buf.position()); // 2
        // 判断缓冲区是否还有剩余的数据
        if(buf.hasRemaining()){
            // 获取缓冲区中可以操作的数量
            System.out.println(buf.remaining());
        }
    }

    @Test
    public void testDirect(){
        // 分配直接缓冲区
        ByteBuffer buf = ByteBuffer.allocateDirect(1024);
        // 判断是否是直接缓冲区
        System.out.println(buf.isDirect());
    }

    @Test
    public void testCopyFile(){
        String srcPath = "src/main/resources/file/1.txt";
        String dstPath = "src/main/resources/file/2.txt";
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel fisChannel = null;
        FileChannel fosChannel = null;
        ByteBuffer buf = ByteBuffer.allocate(1024);

        try {
            fis = new FileInputStream(srcPath);
            fos = new FileOutputStream(dstPath);
            fisChannel = fis.getChannel();
            fosChannel = fos.getChannel();
            while (fisChannel.read(buf) != -1){
                buf.flip();
                fosChannel.write(buf);
                buf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null){
                try { fis.close(); } catch (IOException e) { e.printStackTrace(); }
            }
            if(fos != null){
                try { fos.close(); } catch (IOException e) { e.printStackTrace(); }
            }
            if (fisChannel != null){
                try { fisChannel.close(); } catch (IOException e) { e.printStackTrace(); }
            }
            if (fosChannel != null){
                try { fosChannel.close(); } catch (IOException e) { e.printStackTrace(); }
            }
        }
    }
}
