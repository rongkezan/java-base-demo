package com.demo.collection.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author keith
 */
public class ArrayListCopyDemo {
    public static void main(String[] args) {
        List<String> list = Stream.of("1","2","3","4").collect(Collectors.toList());
        List<String> dest = Arrays.asList(new String[list.size()]);
        Collections.copy(dest, list);
        System.out.println(dest);
    }
}
