package com.demo.collection.map;

import com.demo.collection.entity.CollectionUser;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMap 是根据Key进排序的，要求Key是同一个类创建的对象
 *
 * @author keith
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        Map<CollectionUser, String> map = new TreeMap<>(Comparator.comparingInt(CollectionUser::getAge));
        map.put(new CollectionUser("李四", 28, 2600.00), "a");
        map.put(new CollectionUser("王五", 28, 2100.00), "b");
        map.put(new CollectionUser("赵六", 58, 5500.00), "c");
        map.put(new CollectionUser("阿七", 17, 100.00), "d");
        System.out.println(map);
    }
}
