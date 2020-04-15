package com.demo.test.collection;

import com.demo.test.collection.entity.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestListApi {

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
        stuList.add(new Student(20160001L, "孔明", 20, 1, "土木工程", "武汉大学"));
        stuList.add(new Student(20160002L, "伯约", 21, 2, "信息安全", "武汉大学"));
        stuList.add(new Student(20160003L, "玄德", 22, 3, "经济管理", "武汉大学"));
        stuList.add(new Student(20160004L, "云长", 21, 2, "信息安全", "武汉大学"));
        stuList.add(new Student(20161001L, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
        stuList.add(new Student(20161002L, "元直", 23, 4, "土木工程", "华中科技大学"));
        stuList.add(new Student(20161003L, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
        stuList.add(new Student(20162001L, "仲谋", 22, 3, "土木工程", "浙江大学"));
        stuList.add(new Student(20162002L, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
        stuList.add(new Student(20163001L, "丁奉", 24, 5, "土木工程", "南京大学"));
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
    public void testListRetainAll(){
        List<String> list2 = new ArrayList<String>();
        list2.add("We are the family.");
        list2.add("Hello World!");
        list.retainAll(list2);
        System.out.println(list);
    }

    @Test
    public void testListContainsAll(){
        List<String> list2 = new ArrayList<String>();
        list2.add("We are the family.");
        list2.add("Hello World!");
        Boolean contains = list.containsAll(list2);
        System.out.println(contains);
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
