package com.demo.thread;

import com.demo.thread.create.CommonThreadPool;

import java.util.Arrays;
import java.util.List;

/**
 * @author keith
 */
public class TestThreadArrayList {

    private static final List<String> list1 = Arrays.asList("1", "2", "3", "4", "5");
    private static final List<String> list2 = Arrays.asList("a", "b", "c", "d", "e");
    private static List<String> list = null;

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 2; i++) {
                final int ii = i;
                CommonThreadPool.execute(() -> {
                    if (ii == 0) {
                        list = list1;
                    } else {
                        list = list2;
                    }
                    System.out.println();
                    for (String s : list) {
                        System.out.println(Thread.currentThread().getName() + "\t" + s);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CommonThreadPool.shutdown();
        }
    }
}
