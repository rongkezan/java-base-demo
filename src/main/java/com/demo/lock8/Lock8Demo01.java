package com.demo.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 八锁演示
 * 1. 标准访问，先打印 Send Email
 * 2. 在sendEmail()中停3秒，还是先打印 Send Email
 * 3. 新增了普通的sayHello()，先打印 Say Hello
 * 4. 两部手机，先打印 Send Message
 * 5. 两个静态同步方法，同一部手机，先打印 Send Email
 * 6. 两个静态同步方法，同一部手机，先打印 Send Email
 * 7. 一个静态同步方法，一个普通同步方法，一部手机，先打印 Send Message
 * 8. 一个静态同步方法，一个普通同步方法，两部手机，先打印 Send Message
 *
 * why synchronized? multiple threads compete one object
 * 为什么要用 synchronized? 多个线程竞争一个资源类
 *
 * this object is locked, other thread cannot get into this object call another synchronized function
 * 锁的是当前对象this，被锁定后，其它的线程都不能进入到当前对象的其它synchronized方法
 *
 * synchronized not impact normal function
 * synchronized 不影响普通方法
 *
 * different object have different lock
 * 不同的资源类拥有不同的锁
 *
 * static synchronized is global lock, it locked the Class object. for example, two object have a one lock.
 * static synchronized 是一个全局锁，锁的是当前类的Class对象，例：2个由同一个类new出来的对象共享同一把锁
 */
class Phone01{
    public static synchronized void sendEmail() throws Exception{
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Send Email");
    }

    public synchronized void sendMessage() throws Exception{
        System.out.println("Send Message");
    }

    public void sayHello() throws Exception{
        System.out.println("Say Hello");
    }
}

public class Lock8Demo01 {
    public static void main(String[] args) throws InterruptedException {
        Phone01 phone = new Phone01();

        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();

        Thread.sleep(100);

        new Thread(() -> {
            try {
                phone.sendMessage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();
    }
}
