package com.demo.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Fork/Join
 * 当执行新的任务时它可以将其拆分分成更小的任务执行，并将小任务加 到线程队列中，然后再从一个随机线程的队列中偷一个并把它放在自己的队列中。
 *
 * 案例: 计算从 0 加到 100000000
 */
public class TestForkJoinPool {
    static class MyCalculate extends RecursiveTask<Long> {
        private static final long THRESHOLD = 10000L;   // 临界值
        private long start;
        private long end;

        public MyCalculate(long start, long end){
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            long length = end - start;
            if(length <= THRESHOLD){
                long sum = 0;
                for (long i = start; i <= end; i++){
                    sum += i;
                }
                return sum;
            } else{
                long middle = (start + end) / 2;
                MyCalculate left = new MyCalculate(start, middle);
                left.fork();
                MyCalculate right = new MyCalculate(middle + 1, end);
                right.fork();
                return left.join() + right.join();
            }
        }
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new MyCalculate(0, 100000000);
        Long sum = pool.invoke(task);
        System.out.println(sum);
    }
}
