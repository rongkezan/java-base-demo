package com.demo.basic.reflection.test;

import com.demo.basic.reflection.entity.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的属性结构
 */
public class TestField {
    // 获取属性
    @Test
    public void test1(){
        Class<Person> clazz = Person.class;

        // getFields() 获取当前运行时类及其父类中声明为public的属性
        Field[] fields = clazz.getFields();
        for (Field field : fields){
            System.out.println(field);
        }

        System.out.println("-----------------------------------");

        // getDeclaredFields() 获取当前运行时类自己定义的属性（任何权限），不包含父类中声明的属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field field : declaredFields){
            System.out.println(field);
        }
    }

    // 获取属性详情: 权限修饰符 数据类型 变量名
    @Test
    public void test2(){
        Class<Person> clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field field : declaredFields){
            // 权限修饰符
            int modifiers = field.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");
            // 数据类型
            Class<?> type = field.getType();
            System.out.print(type + "\t");
            // 变量名
            String name = field.getName();
            System.out.print(name + "\t");

            System.out.println();
        }
    }
}
