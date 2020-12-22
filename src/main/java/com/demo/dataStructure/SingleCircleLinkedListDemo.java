package com.demo.dataStructure;

import org.w3c.dom.Node;

/**
 * 单向环形链表(约瑟夫问题)
 * 1. 先创建第一个节点，让first指向该节点，并形成环形
 * 2. 每创建一个新节点，就把该节点加入到已有的环形链表中
 *
 * 约瑟夫问题:
 * N个人围成一圈，从第一个开始报数，第M个将被出圈，最后剩下一个，例如N=6，M=5，出圈的顺序是：5，4，6，2，3。
 */
public class SingleCircleLinkedListDemo {
    static class Node{
        int no;
        Node next;
        public Node(int no){
            this.no = no;
        }
    }

    static class LinkedList{
        int size;
        Node first;

        public void init(int num){
            if (num < 1)
               throw new UnsupportedOperationException("num must greater then 0");
            this.size = num;
            // create circle linked list
            Node curr = null;
            for (int i = 1; i <= num; i++){
                Node node = new Node(i);
                if (i == 1){
                    first = node;
                    first.next = first; // make a circle
                    curr = first;
                } else {
                    curr.next = node;
                    node.next = first;
                    curr = node;
                }
            }
        }

        public void showAll(){
            Node curr = first;
            while (true){
                System.out.printf("The no of node: %d\n", curr.no);
                if (curr.next == first)
                    break;
                curr = curr.next;
            }
        }

        /**
         * 计算出圈顺序
         * @param count 数几个数字
         */
        public void out(int count){
            if (first == null)
                throw new UnsupportedOperationException("List is empty");
            Node curr = first;
            while (curr.next != first) {
                curr = curr.next;
            }
            while (curr != first) {
                for (int i = 0; i < count - 1; i++) {
                    first = first.next;
                    curr = curr.next;
                }
                System.out.println("The out no of node: " + first.no);
                // delete the out node
                first = first.next;
                curr.next = first;
            }
            System.out.println("Last node: " + first.no);
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.init(5);
        list.showAll();
        System.out.println();
        list.out( 2);
    }
}
