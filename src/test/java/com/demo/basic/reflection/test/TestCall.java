package com.demo.basic.reflection.test;

import com.demo.basic.reflection.entity.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类中执行结构: 属性、方法、构造器
 */
public class TestCall {

    @Test
    public void testField() throws Exception{
        Class<Person> clazz = Person.class;
        // 创建运行时类的对象
        Person person = clazz.newInstance();
        // 获取指定的属性
        Field id = clazz.getField("id");
        // set() 设置当前属性的值
        // 参数1 指明设置哪个属性， 参数2 将此属性设置为多少
        id.set(person, 1001);
        // get() 设置当前属性的值
        // 参数1 获取哪个对象属性的值
        Object o = id.get(person);
        System.out.println(o);
    }

    @Test
    public void testField2() throws Exception{
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);   // 保证当前属性是可访问的
        name.set(person, "张三");
        Object result = name.get(person);
        System.out.println(result);
    }

    // 调用方法
    @Test
    public void testMethod() throws Exception{
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();
        // getDeclaredMethod() 参数1 指明获取的方法名， 参数2 指明获取方法的参数列表
        Method show = clazz.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        // 调用方法 参数1 方法的调用者， 参数2 方法的实参
        // invoke() 的返回值即为对应类中调用方法的返回值
        Object chn = show.invoke(person, "CHN");
        System.out.println(chn);
    }

    // 调用静态方法
    @Test
    public void testMethod2() throws Exception{
        Class<Person> clazz = Person.class;
        Method display = clazz.getDeclaredMethod("display", String.class);
        display.setAccessible(true);
        Object invoke = display.invoke(Person.class, "篮球");
        System.out.println(invoke);
    }

    // 调用运行时类指定的构造器
    @Test
    public void testConstructor() throws Exception{
        Class<Person> clazz = Person.class;
        // 获取指定构造器
        Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        //调用此构造器
        Person person = constructor.newInstance("Tom");
        System.out.println(person);
    }
}
