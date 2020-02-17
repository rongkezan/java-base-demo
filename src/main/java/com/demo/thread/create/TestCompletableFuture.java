package com.demo.thread.create;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Future接口可以构建异步应用，但是有局限性，它很难直接表述多个Future结果之间的依赖性如
 * - 将多个异步计算的结果合并成一个
 * - 等待Future集合中的所有任务都完成
 * - Future完成事件 (任务完成后触发的动作)
 *
 * 缺点:
 * - 任务出现异常无法感知
 */
public class TestCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程开始:" + Thread.currentThread());
            String uuid = UUID.randomUUID().toString();
            return uuid;
        }, pool).thenApply((r) -> {
            System.out.println("上一步的结果是: " + r);
            return r.replace("-", "");
        }).whenComplete((r, e) -> {
            System.out.println("方法执行完后的结果是:" + r);
            System.out.println("方法执行完后的异常是:" + e);
        });
        System.out.println(future.get());
    }
}
