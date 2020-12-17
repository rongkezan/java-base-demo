package com.demo.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 线程创建方式3: 使用Callable接口
 * - 相比run()方法，可以有返回值
 * - 方法可以抛出异常
 * - 支持泛型的返回值
 * - 需要借助FutureTask类，比如获取返回结果
 *
 * Future接口
 * - 可以对具体Runnable、Callable任务的执行结果进行取消、查询是否完成，获取结果等
 * - FutureTask是Future接口唯一的实现类
 * - FutureTask同时实现了Runnable,Future等接口，它既可作为Runnable线程执行，又可作为Future的到Callable的返回值
 */
public class ThreadCreate3 {
    static class MyThread implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            System.out.println(Thread.currentThread().getName() + "\t 运行了...");
            Integer sum = 0;
            for (int i = 0; i < 100; i++) {
                if(i % 2 == 0){
                    sum += i;
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread t = new MyThread();
        FutureTask<Integer> futureTask = new FutureTask<>(t);
        new Thread(futureTask).start();
        Integer sum = futureTask.get();
        System.out.println("总和为:" + sum);
        new Thread(() -> {

        }).start();
    }
}
