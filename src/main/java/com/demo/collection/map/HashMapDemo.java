package com.demo.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Map: k-v存储
 * - HashMap: Thread not safe
 *      - LinkedHashMap: order by sequence when you iterate
 *                       cause: 在原有的HashMap底层基础上添加了一对指针，指向前一个和后一个元素
 *                       对于频繁的遍历操作，此类的执行效率高于HashMap
 * - TreeMap: 保证按照添加的key-value进行排序，实现排序遍历
 * - Hashtable: Thread safe
 *      - Properties: 常用来处理配置文件，key-value都是String类型
 *
 * HashMap的底层实现原理
 *
 * HashMap map = new HashMap();
 * 在实例化以后，底层创建了一个长度是16的一维数组 Entry[]
 * map.put(k1, v1);
 * 首先调用k1所在类的hashCode()计算哈希值，此哈希值经过某种算法计算之后，得到在Entry数组中的存放位置
 * 如果此位置上的数据为空，此时的entry1添加成功
 * 如果此位置上的数据不为空(意味着此位之上存在一个或多个数据(以链表形式))，比较当前k1和已存在的数据key的哈希值
 *  - 如果k1的哈希值与已经存在的哈希值都不相同，此时entry1添加成功
 *  - 否则调用k1所在类的equals()方法进行比较，如果不同则添加成功，如果相同则使用v1替换相同key的value值
 *
 * 在不断添加的过程中，会涉及到扩容问题，当超出临界值(且要存放的位置非空时)扩容，默认扩容方式: 扩容为原来容量的2倍，并将原有的数据复制过来。
 * jdk8中new HashMap()没有创建长度为16的数组，首次调用put()时底层是创建长度为16的数组。
 * HashMap底层: 数组 + 链表 + 红黑树 (jdk 8)
 * 当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8 且当前数组长度 > 64 时，此时此索引位置上的所有数据改为使用红黑树存储。
 *
 * @author keith
 */
public class HashMapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Hello World!");
        Map<Integer, String> map2 = new HashMap<>();
        map2.put(5, "this is new map row 1");
        map2.put(6, "this is new map row 2");
        map2.put(7, "this is new map row 3");
        map.putAll(map2);
        for (Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println("key = " + entry.getKey() + ",value = " + entry.getValue());
        }
    }
}
