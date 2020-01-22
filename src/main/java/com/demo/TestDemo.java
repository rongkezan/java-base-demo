package com.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account{
    private int totalMoney = 0;
    private Lock lock = new ReentrantLock();

    public void deposit(){
        try {
            lock.lock();
            for (int i = 0; i < 3; i++) {
                totalMoney += 1000;
                System.out.println(Thread.currentThread().getName() + "存入1000元，余额为:\t" + totalMoney);
            }
        } finally {
            lock.unlock();
        }
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Account account = new Account();
        for(int i = 1; i <= 2; i++){
            new Thread(() -> {
                account.deposit();
            }, String.valueOf(i)).start();
        }
    }
}
