package com.demo.thread.example;

/**
 * 题目: 三个窗口卖100张票
 * 操作同步代码时，只能有一个线程参与，其它线程等待。相当于是一个单线程的过程，效率低。
 *
 * 1. 同步代码块
 * synchronized (同步监视器) {
 *     // 需要被同步的代码
 * }
 * 说明:
 * (1) 操作共享数据的代码，即为需要被同步的代码
 * (2) 共享数据: 多个线程共同操作的变量
 * (3) 同步监视器，俗称"锁"，任何一个类的对象，都可以充当"锁"，多个线程必须要用同一把锁
 *
 * 2. 同步方法
 * 如果操作共享数据的代码完整的声明在一个方法中，可以把此方法设置为同步的。
 *
 */
public class TestSellTicket2 {

    static class Window implements Runnable{
        private int ticket = 100;

        @Override
        public void run() {
            while (true){
                sell();
                if (ticket == 0){
                    break;
                }
            }
        }

        private synchronized void sell(){   // 同步监视器 this
            if(ticket > 0){
                ticket --;
                System.out.println(Thread.currentThread().getName() + "卖掉了一张票，剩余票数:\t" + ticket);
            }
        }
    }

    public static void main(String[] args) {
        Window window = new Window();
        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        Thread t3 = new Thread(window);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
