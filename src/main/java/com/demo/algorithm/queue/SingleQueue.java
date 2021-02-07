package com.demo.algorithm.queue;

/**
 * 单向队列
 *
 * @author keith
 */
public class SingleQueue {
    /* 队列最大大小 */
    private final int maxSize;

    /* 队列中元素的实际数目 */
    private int size;

    /* 头指针 */
    private int front;

    /* 尾指针 */
    private int rear;

    /* 队列数组 */
    private final Object[] array;

    public SingleQueue(int maxSize) {
        this.maxSize = maxSize;
        size = 0;
        front = 0;
        rear = -1;
        array = new Object[maxSize];
    }

    public void add(int value) {
        if (isFull()) {
            throw new UnsupportedOperationException("Queue is full, cannot add");
        } else {
            //如果队列尾部指向顶了，那么循环回来，执行队列的第一个元素
            if (rear == maxSize - 1) {
                rear = -1;
            }
            //队尾指针加1，然后在队尾指针处插入新的数据
            array[++rear] = value;
            size++;
        }
    }

    public Object poll() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("Queue is empty, cannot remove");
        }
        Object value = array[front];
        array[front] = null;
        front++;
        if (front == maxSize) {
            front = 0;
        }
        size--;
        return value;
    }

    // 查看队头数据
    public Object peek() {
        return array[front];
    }

    // 判断队列是否满了
    public boolean isFull() {
        return size == maxSize;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 返回队列的大小
    public int getSize() {
        return size;
    }
}
