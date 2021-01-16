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
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> 1);
        new Thread(futureTask).start();
        Integer result = futureTask.get();
        System.out.println("结果:" + result);
    }
}
