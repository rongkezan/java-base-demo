package com.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 使用Callable接口创建线程 -- Jdk5.0新增
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
public class TestThreadCreate3 {

    static class MyThread implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            Integer sum = 0;
            for (int i = 0; i < 100; i++) {
                if(i % 2 == 0){
                    System.out.println(i);
                    sum += i;
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        FutureTask<Integer> futureTask = new FutureTask<>(myThread);
        new Thread(futureTask).start();
        // get() 返回值即为FutureTask构造器参数Callable实现重写的call()的返回值
        Integer sum = futureTask.get();
        System.out.println("总和为:" + sum);
    }
}
