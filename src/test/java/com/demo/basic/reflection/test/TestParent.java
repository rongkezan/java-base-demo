package com.demo.basic.reflection.test;

import com.demo.basic.reflection.entity.Person;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 获取运行时类的父类
 */
public class TestParent {

    // 获取运行时类的父类
    @Test
    public void test1(){
        Class<Person> clazz = Person.class;
        Class<? super Person> superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }

    // 获取运行时类的带泛型的父类
    @Test
    public void test2(){
        Class<Person> clazz = Person.class;
        Type superclass = clazz.getGenericSuperclass();
        System.out.println(superclass);
    }

    // 获取运行时类的带泛型的父类的泛型
    @Test
    public void test3(){
        Class<Person> clazz = Person.class;
        Type superclass = clazz.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) superclass;
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        for (Type actualTypeArgument : actualTypeArguments) {
            System.out.println(actualTypeArgument.getTypeName());
        }
    }
}
