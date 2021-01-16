package com.demo;

import java.util.concurrent.*;

public class Test {

    static TransferQueue<String> transferQueue = new LinkedTransferQueue<>();
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                String value = transferQueue.take();
                System.out.println("子线程取到主线程数据:" + value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(1000);
        transferQueue.transfer("1");
    }
}
