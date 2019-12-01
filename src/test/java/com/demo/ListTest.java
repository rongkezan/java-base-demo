package com.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {

    private List<String> list = new ArrayList<String>();

    private List<Student> stuList = new ArrayList<Student>();

    @Before
    public void initList(){
        list.add("Hello World!");
        list.add("We are the family.");
        list.add("Peace & Love");
    }

    @Test
    public void testListAdd(){
        list.add("this is row 4");
        list.add("this is row 5");
        list.add("this is row 6");
        for (String str : list){
            System.out.println(str);
        }
    }

    @Test
    public void testListAddObj(){
        stuList.add(new Student(1, "张三", 22));
        stuList.add(new Student(2, "李四", 23));
        stuList.add(new Student(3, "王五", 24));
        for (Student stu : stuList){
            System.out.println(stu);
        }
    }

    @Test
    public void testListAddAll(){
        List<String> list2 = new ArrayList<String>();
        list2.add("this is new list row 1");
        list2.add("this is new list row 2");
        list2.add("this is new list row 3");
        list.addAll(list2);
        System.out.println(list);
    }

    @Test
    public void testListSet(){
        list.set(1, "What's up bro.");
        for (String str : list){
            System.out.println(str);
        }
    }

    @Test
    public void testListRemoveByIndex(){
        list.remove(2);
        for(String str : list){
            System.out.println(str);
        }
    }

    @Test
    public void testListRemoveByObj(){
        list.remove("Peace & Love");
        for(String str : list){
            System.out.println(str);
        }
    }

    @Test
    public void testListRemoveBatch(){
        Iterator iter = list.iterator();
        while(iter.hasNext()){
            String str = (String) iter.next();
            if("We are the family.".equals(str) || "Hello World!".equals(str)){
                iter.remove();
            }
        }
        for(String str : list){
            System.out.println(str);
        }
    }

    @Test
    public void testListRemoveAll(){
        List<String> list2 = new ArrayList<String>();
        list2.add("We are the family.");
        list2.add("Hello World!");
        list.removeAll(list2);
        System.out.println(list);
    }

    @Test
    public void testListToArray(){
        Object[] arr = list.toArray();
        for (Object obj : arr){
            String str = (String) obj;
            System.out.println(str);
        }
    }
}

@Data
@AllArgsConstructor
class Student{
    private Integer id;
    private String name;
    private Integer age;
}
