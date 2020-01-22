package com.demo.basic;

import com.demo.basic.entity.Person;
import org.junit.Test;

import java.util.Random;

/**
 * 通过反射创建对应的运行时类的对象
 * newInstance() 创建对应的运行时类的对象
 * 1. 内部调用了运行时类的空参构造器
 * 2. 空参构造器的权限得够
 */
public class TestNewInstance {
    @Test
    public void test1() throws Exception {
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();
        System.out.println(person);
    }

    @Test
    public void test2() throws Exception {
        for (int i = 0; i < 10; i++) {
            int num = new Random().nextInt(3);
            String classPath = "";
            switch (num) {
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "com.demo.basic.entity.Person";
                    break;
            }
            Object instance = getInstance(classPath);
            System.out.println(instance);
        }
    }

    /**
     * 创建一个指定类的对象
     *
     * @return
     */
    public Object getInstance(String classPath) throws Exception {
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}
