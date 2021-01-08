package com.demo.collection.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap 可以根据添加的顺序遍历
 *
 * @author keith
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("1", "aa");
        map.put("3", "bb");
        map.put("2", "cc");
        map.put("4", "dd");
        System.out.println(map);
    }
}
