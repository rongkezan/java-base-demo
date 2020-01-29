package com.demo.basic.reflection.test;

import com.demo.basic.reflection.entity.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;

/**
 * 获取运行时类的接口、包、注解
 */
public class TestOther {

    // 获取运行时类的接口
    @Test
    public void test1(){
        Class<Person> clazz = Person.class;
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
        System.out.println("------------ 获取父类的接口 ---------------");
        // 获取父类的接口
        Class<?>[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class<?> aClass : interfaces1) {
            System.out.println(aClass);
        }
    }

    // 获取运行时类所在的包
    @Test
    public void test2(){
        Class<Person> clazz = Person.class;
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }

    // 获取运行时类的注解
    @Test
    public void test3(){
        Class<Person> personClass = Person.class;
        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}
