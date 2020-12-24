package com.demo.dataStructure.stack;

/**
 * 使用栈实现计算器
 * 数栈：numStack
 * 符号栈：operStack
 *
 * 遍历表达式
 * 如果是数字则入数栈
 * 如果是符号则入符号栈
 *  如果符号栈有操作符且当前的操作符的优先级<=栈中的操作符，就需要从数栈中pop出两个数，再从符号栈中pop出一个符号，进行运算，将得到的结果入数栈，
 *  然后将当前的操作符入符号栈，如果当前操作符优先级>栈中的操作符就直接入栈，当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号并运算
 *  最后数栈只有一个数字 即结果
 */
public class Calculator {
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

        public int peek(){
            if (isEmpty())
                throw new UnsupportedOperationException("Stack is Empty");
            return arr[top];
        }

        // Begin with top when traversing
        public void showAll(){
            for (int i = top; i >= 0; i--){
                System.out.printf("stack[%d]=%d\n", i, arr[i]);
            }
        }

        public int priority(int oper){
            if (oper == '*' || oper == '/'){
                return 1;
            } else if (oper == '+' || oper == '-'){
                return 0;
            } else {
                return -1;
            }
        }

        public boolean isOperation(char val){
            return val == '+' || val == '-' || val == '*' || val == '/';
        }

        public int cal(int num1, int num2, int oper){
            int res = 0;
            switch (oper){
                case '+':
                    res = num1 + num2;
                    break;
                case '-':
                    res = num1 - num2;
                    break;
                case '*':
                    res = num1 * num2;
                    break;
                case '/':
                    res = num1 / num2;
                    break;
                default:
                    break;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        String expression = "3+2*6-2";
        Stack numStack = new Stack(10);
        Stack operStack = new Stack(10);
        int index = 0, num1 = 0, num2 = 0, oper = 0, res = 0;
        char ch = ' '; // 将每次扫描得到的char保存到tmp
        do {
            ch = expression.substring(index, index + 1).charAt(0);
            if (operStack.isOperation(ch)) {
                if (!operStack.isEmpty()) {
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        res = numStack.cal(num2, num1, operStack.pop());
                        numStack.push(res);
                    }
                }
                operStack.push(ch);
            } else {
                numStack.push(ch - 48);
            }
            index++;
        } while (index != expression.length());

        while (!operStack.isEmpty()) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            res = numStack.cal(num2, num1, operStack.pop());
            numStack.push(res);
        }

        System.out.printf("%s = %d", expression, res);
    }
}
