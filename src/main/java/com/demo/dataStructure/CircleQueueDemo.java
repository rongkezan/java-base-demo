package com.demo.dataStructure;

/**
 * 使用数组实现环形队列
 * 关键因素 在原数组的基础上取模得到环形队列的下标
 */
public class CircleQueueDemo {
    static class CircleQueue{
        private int maxSize;
        private int front;
        private int rear;
        private int arr[];

        public CircleQueue(int maxSize){
            this.maxSize = maxSize + 1;
            arr = new int[maxSize + 1];
        }

        public boolean isFull(){
            return (rear + 1) % maxSize == front;
        }

        public boolean isEmpty(){
            return rear == front;
        }

        public void add(int n){
           if (isFull())
                throw new UnsupportedOperationException("cannot add element to full queue");
            arr[rear] = n;
            rear = (rear + 1) % maxSize;
        }

        public int poll(){
            if (isEmpty())
                throw new UnsupportedOperationException("cannot poll element to empty queue");
            int value = arr[front];
            front = (front + 1) % maxSize;
            return value;
        }

        public void showAll(){
            for (int i = front; i < front + size(); i++){
                System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
            }
        }

        public int size() {
            return (rear - front + maxSize) % maxSize;
        }
    }

    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.showAll();
        System.out.println();
        queue.poll();
        queue.showAll();
        System.out.println();
        queue.add(4);
        queue.showAll();
        System.out.println();
        queue.poll();
        queue.showAll();
        System.out.println();
        queue.add(5);
        queue.showAll();
    }
}
