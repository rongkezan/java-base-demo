package com.demo.leetCode;

import java.util.*;

/**
 * 依赖LinkedHashMap的LRU算法的实现
 * @param <K>
 * @param <V>
 */
public class LruCacheDemo<K, V> extends LinkedHashMap<K, V> {

    private int capacity;   // 缓存容量

    public LruCacheDemo(int capacity){
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LruCacheDemo<Integer, String> lru = new LruCacheDemo<>(3);
        lru.put(1, "a");
        lru.put(2, "b");
        lru.put(3, "c");
        lru.get(1);
        lru.put(4, "d");
        System.out.println(lru.keySet());
        List<String> list = new LinkedList<>();
    }
}
