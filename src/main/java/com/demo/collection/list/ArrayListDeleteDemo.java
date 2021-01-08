package com.demo.collection.list;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author keith
 */
public class ArrayListDeleteDemo {

    /**
     * list.removeIf(next -> "2".equals(next) || "3".equals(next));
     *
     * 等价于:
     *
     * while (iterator.hasNext()){
     *     String next = iterator.next();
     *     if ("2".equals(next) || "3".equals(next))
     *         iterator.remove();
     * }
     */
    public static void main(String[] args) {
        List<String> list = Stream.of("1","2","3","4").collect(Collectors.toList());
        list.removeIf(next -> "2".equals(next) || "3".equals(next));
        System.out.println(list);
    }
}
