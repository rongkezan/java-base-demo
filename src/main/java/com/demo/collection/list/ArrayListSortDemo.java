package com.demo.collection.list;

import com.demo.collection.entity.CollectionUser;

import java.util.Arrays;
import java.util.List;

/**
 * @author keith
 */
public class ArrayListSortDemo {
    public static void main(String[] args) {
        List<CollectionUser> collectionUsers = Arrays.asList(
                new CollectionUser("张三", 19, 2200.00),
                new CollectionUser("李四", 28, 2600.00),
                new CollectionUser("王五", 28, 2100.00),
                new CollectionUser("赵六", 58, 5500.00),
                new CollectionUser("阿七", 17, 100.00)
        );

        collectionUsers.sort((e1, e2) -> {
            if (e1.getAge().equals(e2.getAge())) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });

        for (CollectionUser emp : collectionUsers){
            System.out.println(emp);
        }
    }
}
