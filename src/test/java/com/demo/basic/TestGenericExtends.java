package com.demo.basic;

import com.demo.basic.entity.Person;
import com.demo.basic.entity.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 1. 泛型在继承方面的体现
 * 类A是类B的父类，但G<A>和G<B>二者不具备子父类关系，二者是并列关系
 *
 * 2. 通配符的使用
 * 通配符  ?
 *
 */
public class TestGenericExtends {

    @Test
    public void test1() {
        /**
         * 此时的list1和list2的类型不具有子父类关系，编译无法通过
         * List<Object> list1 = new ArrayList<>();
         * List<String> list2 = new ArrayList<>();
         * list1 = list2;
         */
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        show(list1);
        //show(list2);  //若是没有继承这行会导致没有多态
    }

    public void show(List<Object> list){

    }

    /**
     * 通配符的使用
     * 类A是类B的父类，G<A>和G<B>是没有关系的，二者共同的父类是G<?>
     */
    @Test
    public void test2(){
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<?> list = null;

        list = list1;
        list = list2;

        print(list1);
        print(list2);
    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }

    /**
     * 使用通配符后
     * 无法写入，除了null
     * 可以读取，读取的类型为Object
     */
    @Test
    public void test3(){
        List<String> list = new ArrayList<>();
        list.add("AA");
        list.add("BB");
        list.add("CC");

        List<?> list2 = null;
        list2 = list;
        //list2.add("DD"); // 无法添加

        Object o = list2.get(0);
        System.out.println(o);
    }

    /**
     * 有限制条件的通配符的使用
     *  G<? extends A>   ? 是A的子类，可以看成 <=
     *  G<? super A>     ? 是A的父类，可以看成 >=
     *
     *  ? 可以看成是 负无穷 ~ 正无穷 的一个区间
     *  G<? extends A> 表示 负无穷 ~ A
     *  G<? super A>   表示 A ~ 正无穷
     */
    @Test
    public void test4(){
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = null;
        List<Person> list4 = null;
        List<Object> list5 = null;

        list1 = list3;
        list1 = list4;
        //list1 = list5;

        //list2 = list3;
        list2 = list4;
        list2 = list5;

        //报错，编译不通过，父类不能赋值给子类，例： ArrayList list = new List() 是不对的
        //list1.add(new Student());
        list2.add(new Person());
        list2.add(new Student());
    }
}
