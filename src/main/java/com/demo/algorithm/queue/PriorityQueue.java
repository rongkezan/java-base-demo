package com.demo.algorithm.queue;

/**
 * @author keith
 */
public class PriorityQueue {

    /* 最大大小 */
    private final int maxSize;

    /* 实际大小 */
    private int size;

    /* 队列数组 */
    private final int[] array;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        size = 0;
        array = new int[maxSize];
    }

    // 插入数据
    public void add(int value) {
        if (size == 0) {
            array[size++] = value;
        } else {
            int j = size - 1;
            // 选择的排序方法是插入排序，按照从大到小的顺序排列，越小的越在队列的顶端
            while (j >= 0 && value > array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = value;
            size++;
        }
    }

    // 移除数据,由于是按照大小排序的，所以移除数据我们指针向下移动
    // 被移除的地方由于是int类型的，不能设置为null，这里的做法是设置为 -1
    public int poll() {
        int k = size - 1;
        int value = array[k];
        array[k] = -1;  // -1表示这个位置的数据被移除了
        size--;
        return value;
    }

    // 查看优先级最高的元素
    public int peekMin() {
        return array[size - 1];
    }

    // 判断是否为空
    public boolean isEmpty() {
        return (size == 0);
    }

    // 判断是否满了
    public boolean isFull() {
        return (size == maxSize);
    }
}
