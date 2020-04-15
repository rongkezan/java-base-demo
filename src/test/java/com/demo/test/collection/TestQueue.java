package com.demo.test.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 结果表明：
 * 添加元素用 offer()
 * 移除元素用 poll()
 * 查询头元素用 peek()
 */
public class TestQueue {
    private Queue<String> queue = new LinkedList<>();

    /**
     * add()和offer()都是向队列中添加一个元素。
     * 一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，调用 add() 方法就会抛出一个 unchecked 异常。
     * 而调用 offer() 方法会返回 false。因此就可以在程序中进行有效的判断！
     */
    @Before
    public void init(){
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.offer("d");
        queue.offer("e");
        queue.offer("f");
    }

    private void query(){
        for(String str : queue){
            System.out.println(str);
        }
    }

    /**
     * remove() 和 poll() 方法都是从队列中删除第一个元素。
     * 如果队列元素为空，调用remove() 的行为与 Collection 接口的版本相似会抛出异常。
     * 但是新的 poll()方法在用空集合调用时只是返回 null。因此新的方法更适合容易出现异常条件的情况。
     */
    @Test
    public void testRemove(){
        for(int i = 0; i < 7; i++){
            queue.remove();
        }
        query();
    }

    @Test
    public void testPoll(){
        for(int i = 0; i < 7; i++){
            if(queue.poll() == null){
                System.out.println("队列为空");
            }
        }
        query();
    }

    /**
     * element() 和 peek() 用于在队列的头部查询元素。
     * 与 remove() 方法类似，在队列为空时， element() 抛出一个异常，而 peek() 返回 null。
     */
    @Test
    public void testElement(){
        System.out.println(queue.element());
        queue.clear();
        System.out.println(queue.element());
    }

    @Test
    public void testPeek(){
        System.out.println(queue.peek());
        queue.clear();
        System.out.println(queue.peek());
    }
}
