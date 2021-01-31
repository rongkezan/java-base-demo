package com.demo.zk;

import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

public class ZkUtils {
    private static ZooKeeper zk;

    private static final String ADDRESS = "127.0.0.1:2181/lock";

    private static DefaultWatch watch = new DefaultWatch();

    private static CountDownLatch latch = new CountDownLatch(1);

    public static ZooKeeper getInstance() {
        try {
            zk = new ZooKeeper(ADDRESS, 1000000, watch);
            watch.setCc(latch);
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return zk;
    }
}
