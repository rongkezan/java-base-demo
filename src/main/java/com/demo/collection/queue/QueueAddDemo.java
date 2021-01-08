package com.demo.collection.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * add()和offer()都是向队列中添加一个元素。
 * 一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，调用 add() 方法就会抛出一个 unchecked 异常。
 * 而调用 offer() 方法会返回 false。因此就可以在程序中进行有效的判断！
 *
 * @author keith
 */
public class QueueAddDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.offer("d");
        queue.offer("e");
        queue.offer("f");
    }
}
