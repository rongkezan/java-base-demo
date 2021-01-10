package com.demo;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(() -> {
            try {
                exchanger.exchange("1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        new Thread(() -> {
            try {
                exchanger.exchange("2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }
}
