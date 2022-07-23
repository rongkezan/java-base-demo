package com.demo.basic;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author keith
 */
public class AllocateMemoryDemo {

    private static Unsafe unsafe = null;

    static {
        try {
            Field getUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            getUnsafe.setAccessible(true);
            unsafe = (Unsafe) getUnsafe.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long address = unsafe.allocateMemory(10 * 1024);
        System.out.println(address);
    }
}
