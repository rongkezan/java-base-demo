package com.demo.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

public class ZkTest {
    public static void main(String[] args) throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        // 连接zk服务
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 3000, watchedEvent -> {
            Watcher.Event.KeeperState state = watchedEvent.getState();
            Watcher.Event.EventType type = watchedEvent.getType();

            if (state == Watcher.Event.KeeperState.SyncConnected) {
                latch.countDown();
            }
        });
        latch.await();
        // 打印zk状态，如果不加 CountDownLatch，则会打印 connecting，因为是异步连接
        ZooKeeper.States state = zk.getState();
        switch (state) {
            case CONNECTING:
                System.out.println("connecting");
                break;
            case CONNECTED:
                System.out.println("connected");
                break;
            default:
                break;
        }
        // 创建节点
        zk.create("/test", "myData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

        // 同步获取数据
        byte[] node = zk.getData("/test", event -> System.out.println(event.toString()), new Stat());
        System.out.println(new String(node));

        // 设置数据
        zk.setData("/test", "newData".getBytes(), 0);

        // 异步获取数据
        zk.getData("/test", false, (rc, path, ctx, data, stat) ->
                System.out.println(new String(data)), "aa");

        // 阻塞线程 以便获取异步的数据
        Thread.sleep(100000);
    }
}
