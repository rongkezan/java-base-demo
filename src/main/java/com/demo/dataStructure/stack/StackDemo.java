package com.demo.dataStructure.stack;

/**
 * 使用数组来模拟栈
 * 定义一个top表示栈顶，初始化为-1
 * 入栈：top++; stack[top] = data;
 * 出栈：data = stack[top]，top--
 */
public class StackDemo {

    static class Stack{
        int maxSize;
        int top = -1;
        int[] arr;

        public Stack(int maxSize){
            this.maxSize = maxSize;
            arr = new int[maxSize];
        }

        public boolean isFull(){
            return top == maxSize - 1;
        }

        public boolean isEmpty(){
            return top == -1;
        }

        public void push(int val){
            if (isFull())
                throw new UnsupportedOperationException("Stack is full");
            top++;
            arr[top] = val;
        }

        public int pop(){
            if (isEmpty())
                throw new UnsupportedOperationException("Stack is Empty");
            int val = arr[top];
            top--;
            return val;
        }

        // Begin with top when traversing
        public void showAll(){
            for (int i = top; i >= 0; i--){
                System.out.printf("stack[%d]=%d\n", i, arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.showAll();
        System.out.println();
        stack.pop();
        stack.showAll();
    }
}
