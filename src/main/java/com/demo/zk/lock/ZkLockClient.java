package com.demo.zk.lock;

public class ZkLockClient {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                String threadName = Thread.currentThread().getName();
                ZkWatchLock zkWatchLock = new ZkWatchLock();
                zkWatchLock.setThreadName(threadName);
                //抢锁
                zkWatchLock.lock();
                //干活
                System.out.println(threadName + " working...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //释放锁
                zkWatchLock.unLock();
            }).start();
        }

        Thread.sleep(15000);
    }
}
