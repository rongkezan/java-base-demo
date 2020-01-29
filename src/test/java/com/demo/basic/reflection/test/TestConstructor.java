package com.demo.basic.reflection.test;

import com.demo.basic.reflection.entity.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * 获取构造器结构
 */
public class TestConstructor {
    @Test
    public void test1(){
        // 获取当前运行类的public构造器
        Class<Person> clazz = Person.class;
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
    }

    @Test
    public void test2(){
        // 获取当前运行类的所有构造器
        Class<Person> clazz = Person.class;
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
    }
}
