package com.demo.collection.set;

import com.demo.collection.entity.CollectionUser;

import java.util.HashSet;
import java.util.Set;

/**
 * 如需进行对象去重
 * 需在对象中实现equals()和hashcode()方法
 *
 * @author keith
 */
public class HashSetDemo {
    public static void main(String[] args) {
        Set<CollectionUser> set = new HashSet<>();
        set.add(new CollectionUser("张三", 19, 2200.00));
        set.add(new CollectionUser("李四", 28, 2600.00));
        set.add(new CollectionUser("王五", 28, 2100.00));
        set.add(new CollectionUser("赵六", 58, 5500.00));
        set.add(new CollectionUser("赵六", 58, 5500.00));
        System.out.println(set);
    }
}
