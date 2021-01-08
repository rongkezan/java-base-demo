package com.demo.collection.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * remove() 和 poll() 方法都是从队列中删除第一个元素。
 * 如果队列元素为空，调用remove() 的行为与 Collection 接口的版本相似会抛出异常。
 * 但是新的 poll()方法在用空集合调用时只是返回 null。因此新的方法更适合容易出现异常条件的情况。
 *
 * @author keith
 */
public class QueueRemoveDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("a");
        queue.remove();
        queue.poll();
    }
}
