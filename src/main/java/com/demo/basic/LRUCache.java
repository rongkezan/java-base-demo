package com.demo.basic;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap {
    private int cacheSize;

    // 传递进来最多能缓存多少数据
    public LRUCache(int cacheSize){
        // 设置一个HashMap的初始大小，最后一个true表示让LinkedHashMap按照访问顺序排序，最近访问的放在头，最老访问的放在尾
        super((int)Math.ceil((cacheSize / 0.75) + 1), 0.75f, true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        // 当map中的数量大于指定的缓存个数的时候，就自动删除最老的数据
        return size() > cacheSize;
    }
}
