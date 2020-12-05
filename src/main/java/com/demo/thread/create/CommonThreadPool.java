package com.demo.thread.create;

import java.util.concurrent.*;

/**
 * @author keith
 */
public class CommonThreadPool {
    private static ExecutorService exec = new ThreadPoolExecutor(50, 100, 0L,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(10000),
            new ThreadPoolExecutor.CallerRunsPolicy());

    public static void execute(Runnable command) {
        exec.execute(command);
    }

    public static Future submit(Runnable command) { return exec.submit(command); }

    public static Future submit(Callable command) {
        return exec.submit(command);
    }

    public static void shutdown(){
        exec.shutdown();
    }
}
