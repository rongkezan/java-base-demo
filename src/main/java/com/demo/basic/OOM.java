package com.demo.basic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * -Xms20M -Xmx20M -XX:+PrintGC -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:/dump/
 */
public class OOM {
    public static void main(String[] args) {
        while (true) {
            Object[] obj = new Object[5 * 1024 * 1024];
        }
    }
}
