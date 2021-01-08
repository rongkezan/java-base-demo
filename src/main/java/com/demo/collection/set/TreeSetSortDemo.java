package com.demo.collection.set;

import com.demo.collection.entity.CollectionUser;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet判断元素是否相等根据CompareTo的返回值
 * 小于 -1
 * 等于 0
 * 大于 1
 *
 * @author keith
 */
public class TreeSetSortDemo {

    public static void main(String[] args) {
        // 按照年龄从小到大排序
        Set<CollectionUser> set = new TreeSet<>(Comparator.comparingInt(CollectionUser::getAge));
        set.add(new CollectionUser("张三", 19, 2200.00));
        set.add(new CollectionUser("李四", 28, 2600.00));
        set.add(new CollectionUser("王五", 28, 2100.00));
        set.add(new CollectionUser("赵六", 58, 5500.00));
        set.add(new CollectionUser("阿七", 17, 100.00));
        System.out.println(set);
    }
}
