package com.demo.zk.lock;

import com.demo.zk.ZkUtils;
import lombok.Data;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Data
public class ZkWatchLock implements Watcher, AsyncCallback.StringCallback,
        AsyncCallback.Children2Callback, AsyncCallback.StatCallback {

    private static ZooKeeper zk = ZkUtils.getInstance();

    private CountDownLatch latch = new CountDownLatch(1);

    private String pathName;

    private String threadName;

    public void lock() {
        // 创建lock有序节点，值是线程名
        zk.create("/lock", threadName.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL_SEQUENTIAL, this, "a");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void unLock() {
        try {
            zk.delete(pathName, -1);
        } catch (InterruptedException | KeeperException e) {
            e.printStackTrace();
        }
        System.out.println(threadName + " unlock");
    }

    /**
     * Watcher
     */
    @Override
    public void process(WatchedEvent event) {
        if (event.getType() == Event.EventType.NodeDeleted) {
            zk.getChildren("/", false, this, "w");
        }
    }

    /**
     * Children2Callback
     */
    @Override
    public void processResult(int rc, String path, Object ctx, List<String> children, Stat stat) {
        // 每一个节点都能看到自己前面的节点
        System.out.println(threadName + " look locks");
        for (String child : children) {
            System.out.print(child + " ");
        }
        System.out.println();

        // 将节点排序
        Collections.sort(children);

        // 判断是否是第一个节点
        int i = children.indexOf(pathName.substring(1));
        if (i == 0) {
            try {
                zk.setData("/", threadName.getBytes(), -1);
                latch.countDown();
            } catch (KeeperException | InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            zk.exists("/" + children.get(i - 1), this, this, "c");
        }
    }

    /**
     * StringCallback
     */
    @Override
    public void processResult(int rc, String path, Object ctx, String name) {
        if (name != null) {
            System.out.println(threadName + "\tcreate node : " + name);
            pathName = name;
            zk.getChildren("/", false, this, "s");
        }
    }

    /**
     * StatCallback
     */
    @Override
    public void processResult(int rc, String path, Object ctx, Stat stat) {

    }
}
