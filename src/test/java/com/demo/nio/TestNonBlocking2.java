package com.demo.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.time.LocalDateTime;
import java.util.Iterator;

public class TestNonBlocking2 {
    @Test
    public void send() throws IOException {
        DatagramChannel dc = DatagramChannel.open();
        dc.configureBlocking(false);
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put(LocalDateTime.now().toString().getBytes());
        buf.flip();
        dc.send(buf, new InetSocketAddress("127.0.0.1", 9898));
        buf.clear();
        dc.close();
    }

    @Test
    public void receive() throws IOException {
        DatagramChannel dc = DatagramChannel.open();
        dc.configureBlocking(false);
        dc.bind(new InetSocketAddress(9898));
        Selector selector = Selector.open();
        dc.register(selector, SelectionKey.OP_READ);
        while(selector.select() > 0){
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while(iterator.hasNext()){
                SelectionKey sk = iterator.next();
                if(sk.isReadable()){
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    dc.receive(buf);
                    buf.flip();
                    System.out.println(new String(buf.array(), 0, buf.limit()));
                    buf.clear();
                }
                iterator.remove();
            }
        }
    }
}

