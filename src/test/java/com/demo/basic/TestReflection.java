package com.demo.basic;

import com.demo.basic.entity.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflection {
    @Test
    public void test() throws Exception {
        // 通过反射，可以调用Person类的私有结构，如私有的构造器、方法、属性
        Class clazz = Person.class;

        // 调用私有构造方法
        Constructor cons = clazz.getDeclaredConstructor(String.class);
        cons.setAccessible(true);
        Person p1 = (Person) cons.newInstance("Tom");
        System.out.println(p1);

        // 调用私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "Jerry");
        System.out.println(p1);

        // 调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        showNation.invoke(p1, "中国");
    }

    /**
     * Class 表示类的类
     *
     * 1. 类的加载:
     *  程序经过java.exe命令后会生成一个或多个字节码文件(.class)
     *  接着我们使用java.exe命令对某个字节码文件进行解释运行，相当于将某个字节码文件加到内存中
     *  加载到内存的类，称为运行时类，此类就作为Class的一个实例
     *
     * 2. 加载到内存中运行时类，会缓存一段时间。在此时间内，我们可以通过不同的方式来获取此运行时类
     */
    @Test
    public void test2() throws ClassNotFoundException {
        // 获取Class实例的4中方式
        // 1. 调用运行时类的属性 .class
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        // 2. 通过运行时类的对象
        Person person = new Person();
        Class clazz2 = person.getClass();
        System.out.println(clazz2);

        // 3. 调用Class.forName(String classPath)
        Class clazz3 = Class.forName("com.demo.basic.Person");
        System.out.println(clazz3);

        // 4. 使用类加载器
        ClassLoader classLoader = TestReflection.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.demo.basic.Person");
        System.out.println(clazz4);

        // 是否是同一个对象
        System.out.println(clazz1 == clazz2);   // true
        System.out.println(clazz1 == clazz3);   // true
        System.out.println(clazz1 == clazz4);   // true
    }
}
