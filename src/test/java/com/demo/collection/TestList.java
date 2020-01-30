package com.demo.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * List: store data which is sequential and repeatable.
 *
 * what's the difference in
 * ArrayList, LinkedList, Vector
 *
 * Same: All of them implements List interface
 * Difference:
 *  - ArrayList: thread not safe, high efficiency, store by `Object[]`
 *  - LinkedList: if you have more add and remove operation, LinkedList is more effective than ArrayList, cause it store by `double linked list`(双向链表).
 *  - Vector: thread safe, low efficiency, store by `Object[]`
 */
public class TestList  {

    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        System.out.println(list);
    }
}
