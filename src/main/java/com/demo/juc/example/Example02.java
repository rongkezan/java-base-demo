package com.demo.juc.example;

import java.util.LinkedList;

/**
 * 写一个固定容量的同步容器，拥有put和get方法，以及getCount方法
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 */
public class Example02 {

    private static final LinkedList<String> list = new LinkedList<>();

    private static final int MAX = 10;

    private int count = 0;

    public synchronized void put(String val){
        while (list.size() == MAX){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(val);
        count++;
        notifyAll();
    }

    public synchronized String get(){
        String val = null;
        while (list.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        val = list.removeFirst();
        count--;
        notifyAll();
        return val;
    }

    public static void main(String[] args) {
        Example02 ex = new Example02();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++){
                    System.out.println(ex.get());
                }
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++){
                    ex.put(String.valueOf(j));
                }
            }).start();
        }
    }
}
