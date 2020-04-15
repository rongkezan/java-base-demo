package com.demo.test.nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/**
 * 通道 (Channel): 用于源节点和目标节点的连接，用Java NIO 中负责缓冲区中数据的传输。
 * Channel 本身不存储数据，因此需要配合缓冲区进行传输
 *
 *  通道的主要实现类
 *  java.nio.channels.Channel 接口
 *  - FileChannel           TCP
 *  - SocketChannel         TCP
 *  - ServerSocketChannel   UDP
 *  - DatagramChannel	    UDP
 *
 *  获取通道
 *  1. getChannel()
 *      - 本地IO操作: FileInputStream/FileOutputStream/RandomAccessFile
 *      - 网络IO: Socket/ServerSocket/DatagramSocket
 *  2. open()               静态方法
 *  3. newByteChannel()     针对File工具类
 *
 *  通道之间的数据传输
 *  transferFrom()
 *  transferTo()
 *
 *  分散(Scatter)与聚集(Gather)
 *  1. 分散读取(Scattering Reads): 将通道中的数据分散到多个缓冲中
 *  2. 聚集写入(Gathering Writes): 将多个缓冲区中的数据聚集到通道中
 *
 *  字符集
 *  编码: 字符串 -> 字节数组
 *  解码: 字节数组 -> 字符串
 *  编码和解码方式若是同一种则不会乱码，例如: 用GBK编码GBK解码
 */
public class TestChannel {

    // 利用通道完成文件的复制(非直接缓冲区)
    @Test
    public void test1(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            fis = new FileInputStream("E:\\Workspace\\Idea\\java-base-demo\\src\\main\\resources\\img\\1.jpg");
            fos = new FileOutputStream("E:\\Workspace\\Idea\\java-base-demo\\src\\main\\resources\\img\\2.jpg");

            // 获取通道
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            // 分配一个指定大小的缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);

            // 将通道中的数据存入缓冲区中
            while (inChannel.read(buf) != -1){
                buf.flip(); // 切换成读取数据的模式
                outChannel.write(buf);  // 将缓冲区的数据写入通道中
                buf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outChannel != null){
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inChannel != null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    // 使用直接缓冲区完成文件的复制(内存映射文件)
    @Test
    public void test2() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("E:\\Workspace\\Idea\\java-base-demo\\src\\main\\resources\\img\\1.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("E:\\Workspace\\Idea\\java-base-demo\\src\\main\\resources\\img\\2.jpg"),
                StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

        // 内存映射文件
        MappedByteBuffer inMappedBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        // 直接对缓冲区进行数据的读写
        byte[] dst = new byte[inMappedBuffer.limit()];
        inMappedBuffer.get(dst);
        outMappedBuffer.put(dst);

        inChannel.close();
        outChannel.close();
    }

    // 通道之间的数据传输(直接缓冲区)
    @Test
    public void test3() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("E:\\Workspace\\Idea\\java-base-demo\\src\\main\\resources\\img\\1.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("E:\\Workspace\\Idea\\java-base-demo\\src\\main\\resources\\img\\2.jpg"),
                StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);
        //inChannel.transferTo(0, inChannel.size(), outChannel);
        outChannel.transferFrom(inChannel, 0, inChannel.size());
        inChannel.close();
        outChannel.close();
    }

    @Test
    public void test4() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("E:\\Workspace\\Idea\\java-base-demo\\src\\main\\resources\\file\\1.txt", "rw");

        // 获取通道
        FileChannel channel1 = raf1.getChannel();

        // 分配指定大小的缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);

        // 分散读取
        ByteBuffer[] bufs = {buf1, buf2};
        channel1.read(bufs);

        for(ByteBuffer buf : bufs){
            buf.flip();
        }
        System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
        System.out.println("-------------------");
        System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));

        // 聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("E:\\Workspace\\Idea\\java-base-demo\\src\\main\\resources\\file\\2.txt", "rw");
        FileChannel channel2 = raf2.getChannel();
        channel2.write(bufs);
    }

    @Test
    public void test5(){
        SortedMap<String, Charset> map = Charset.availableCharsets();
        for (Map.Entry<String, Charset> entry : map.entrySet()){
            System.out.println("key = " + entry.getKey() + ",value = " + entry.getValue());
        }
    }

    @Test
    public void test6() throws CharacterCodingException {
        Charset charset = Charset.forName("GBK");

        // 获取编码器
        CharsetEncoder ce = charset.newEncoder();

        // 获取解码器
        CharsetDecoder cd = charset.newDecoder();

        CharBuffer cBuf = CharBuffer.allocate(1024);
        cBuf.put("人生不止有眼前的苟且，还有诗和远方~");
        cBuf.flip();
        ByteBuffer encodeBuf = ce.encode(cBuf);
        CharBuffer decodeBuf = cd.decode(encodeBuf);
        System.out.println(decodeBuf.toString());
    }
}
