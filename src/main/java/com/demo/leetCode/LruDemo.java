package com.demo.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 不依赖LinkedHashMap的LRU算法实现
 * map + 双向链表
 * map负责查找，构建一个虚拟的双向链表，使用Node作为数据载体
 */
public class LruDemo {

    // 构造一个Node节点作为数据载体
    static class Node<K, V>{
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node(){
            this.prev = this.next = null;
        }

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }

    // 构建一个虚拟的双向链表，存放Node
    static class DoubleLinkedList<K, V>{
        Node<K, V> head;
        Node<K, V> tail;

        public DoubleLinkedList(){
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        public void addHead(Node<K, V> node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        public void removeNode(Node<K, V> node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = null;
            node.next = null;
        }

        public Node<K, V> getLast(){
            return tail.prev;
        }
    }

    private int cacheSize;

    Map<Integer, Node<Integer, Integer>> map;

    DoubleLinkedList<Integer, Integer> doubleLinkedList;

    public LruDemo(int cacheSize){
        this.cacheSize = cacheSize;
        map = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public int get(int key){
        if (map.containsKey(key)){
            return -1;
        }
        Node<Integer, Integer> node = map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addHead(node);
        return node.value;
    }

    public void put(int key, int value){
        // 更新
        if (map.containsKey(key)){
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key, node);
            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        } else {
            // 满了 删除链表最后的Node
            if (map.size() == cacheSize){
                Node<Integer, Integer> lastNode = doubleLinkedList.getLast();
                map.remove(lastNode.key);
                doubleLinkedList.removeNode(lastNode);
            }
        }
        // 新增
        Node<Integer, Integer> node = new Node<>(key, value);
        map.put(key, node);
        doubleLinkedList.addHead(node);
    }

    public static void main(String[] args) {
        LruDemo lru = new LruDemo(3);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        lru.get(1);
        lru.put(4, 4);
        System.out.println(lru.map.keySet());
    }
}
