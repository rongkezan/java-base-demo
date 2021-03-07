package com.demo.algorithm;

/**
 * 单链表
 */
public class SingleLinkedListDemo {

    static class Node<E> {
        E element;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            return element + "";
        }
    }

    static class LinkedList<E>{
        private Node<E> head;

        void add(E e){
            if (head == null){
                head = new Node<>(e, null);
                return;
            }
            Node<E> tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new Node<>(e, null);
        }

        void add(int index, E e){
            if (index <= 0){
                Node<E> tmp = head;
                head = new Node<>(e, tmp);
            } else {
                Node<E> next = node(index);
                Node<E> prev = node(index - 1);
                prev.next = new Node<>(e, next);
            }
        }

        void remove(int index){
            if (index <= 0){
                head = head.next;
            } else {
                Node<E> prev = node(index - 1);
                prev.next = node(index + 1);
            }
        }

        Node<E> node(int index) {
            if (index < 0)
                index = 0;
            Node<E> tmp = head;
            for (int i = 0; i < index; i++){
                if (tmp == null)
                    break;
                tmp = tmp.next;
            }
            return tmp;
        }

        void showAll(){
            Node<E> tmp = head;
            while (tmp != null){
                System.out.print((tmp) + "\t");
                tmp = tmp.next;
            }
        }

        int size(){
            if (head == null)
                return 0;
            int length = 0;
            Node<E> tmp = head;
            while (tmp != null){
                length++;
                tmp = tmp.next;
            }
            return length;
        }
    }

    public static void main(String[] args) {
        LinkedList<Object> list = new LinkedList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add(0, "ddd");
        list.add(1, "eee");
        list.remove(1);
        System.out.println(list.size());
        list.showAll();
    }
}
