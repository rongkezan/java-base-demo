package com.demo.basic.reflection.test;

import com.demo.basic.reflection.entity.Person;
import org.junit.Test;

import java.awt.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取运行时类的方法结构
 */
public class TestMethod {

    @Test
    public void test1(){
        Class<Person> clazz = Person.class;
        // getMethods() 获取当前类及其父类定义为public的方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods){
            System.out.println(method);
        }
        System.out.println("---------------------------");
        // getDeclaredMethods() 获取当前类的方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }
    }

    @Test
    public void test2(){
        Class<Person> clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            // 获取方法声明的注解
            Annotation[] annotations = method.getAnnotations();
            for (Annotation ann : annotations) {
                System.out.println(ann);
            }
            // 获取权限修饰符
            System.out.print(Modifier.toString(method.getModifiers()) + "\t");
            // 获取返回值类型
            System.out.print(method.getReturnType().getName() + "\t");
            // 获取方法名
            System.out.print(method.getName() + "(");
            // 获取形参列表
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)){
                for (Class<?> parameterType : parameterTypes) {
                    System.out.print(parameterType.getName() + " ");
                }
            }
            System.out.print(")");
            // 抛出的异常
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            if (exceptionTypes.length > 0){
                System.out.print(" throws ");
                for (Class<?> exceptionType : exceptionTypes) {
                    System.out.print(exceptionType + " ");
                }
            }
            System.out.println();

        }
    }
}
