package com.demo.algorithm.queue.circleQueue;

/**
 * @author keith
 */
public class Client {
    public static void main(String[] args) {
        CircularArrayFIFOQueue fifoQueue = new CircularArrayFIFOQueue(3);
        fifoQueue.enqueue(1);
        fifoQueue.enqueue(2);
        fifoQueue.enqueue(3);
        fifoQueue.dequeue();
        fifoQueue.enqueue(4);
        fifoQueue.dequeue();
        fifoQueue.enqueue(5);
        fifoQueue.dequeue();
        fifoQueue.enqueue(6);
        System.out.println(fifoQueue.size());
        fifoQueue.print();
    }
}
