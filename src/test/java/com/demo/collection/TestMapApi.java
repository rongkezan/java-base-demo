package com.demo.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestMapApi {

    private Map<Integer, String> map = new HashMap<>();

    @Before
    public void init(){
        map.put(1, "Hello World!");
        map.put(2, "Yo...");
        map.put(3, "It's me, Jack.");
        map.put(4, "You Jump, I Jump");
    }

    @Test
    public void testQuery(){
        for (Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println("key = " + entry.getKey() + ",value = " + entry.getValue());
        }
    }

    @Test
    public void testQuery2(){
        Iterator<Map.Entry<Integer, String>> entries = map.entrySet().iterator();
        while (entries.hasNext()){
            Map.Entry<Integer, String> entry = entries.next();
            System.out.println("key = " + entry.getKey() + ",value = " + entry.getValue());
        }
    }

    @Test
    public void testQueryPart(){
        for (Integer key : map.keySet()){
            System.out.println("key = " + key);
        }

        for(String value : map.values()){
            System.out.println("value = " + value);
        }
    }

    @Test
    public void testGet(){
        System.out.println(map.get(1));
    }

    @Test
    public void testPutAll(){
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
