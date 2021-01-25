package com.demo.dataStructure.circleQueue;

/**
 * @author keith
 */
public class CircularArrayFIFOQueue implements Queue {

    /* 环形数组大小上限 */
    private static final int MAX_ARRAY_SIZE = 65536;

    /* 环形数组最大长度 */
    private int length;

    /* 环形数组，存放队列元素 */
    private Object[] items;

    /* 队列头部（在 items 中）的下标*/
    private int front;

    /* 队列尾部（在 items 中）的下标 */
    private int rear;

    /**
     * 带参数的构造函数，输入参数为队列初始化的大小。此处约定队列长度不得超过初始化的长度。初始
     * 化时，rear 应指向 front 的“前”一元素。
     *
     * @param initQueueSize 队列中最多可容纳的元素数量
     */
    public CircularArrayFIFOQueue(int initQueueSize) {
        if (initQueueSize > MAX_ARRAY_SIZE)
            throw new UnsupportedOperationException("initQueueSize cannot greater than 65536");
        // 为了满足题目给定的队尾和队首至少留一个元素的需求
        // 即 rear + 2 = front 所以需要留出两个空间
        length = initQueueSize + 2;
        items = new Object[initQueueSize + 2];
    }

    @Override
    public boolean enqueue(Object o) {
        if (isFull())
            throw new UnsupportedOperationException("this queue is full, cannot enqueue");
        items[rear] = o;
        rear = (rear + 1) % length;
        return true;
    }

    @Override
    public Object dequeue() {
        if (isEmpty())
            throw new UnsupportedOperationException("this queue is empty, cannot dequeue");
        Object item = items[front];
        front = (front + 1) % length;
        return item;
    }

    @Override
    public int size() {
        return (rear - front + length) % length;
    }

    public boolean isEmpty(){
        return (rear + 1) % length == front;
    }

    public boolean isFull(){
        return (rear + 2) % length == front;
    }

    public void print(){
        for (int i = front; i < front + size(); i++){
            System.out.printf("arr[%d] = %s\n", i % length, items[i % length]);
        }
    }
}
