package com.demo.collection;

import com.demo.pojo.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    private Set<String> set = new HashSet<String>();

    private Set<Student> stuSet = new HashSet<Student>();

    @Before
    public void initSet(){
        set.add("Hello World.");
        set.add("We are the family.");
        set.add("Yo.");
        set.add("What's up bro.");
        set.add("It's me, Jack.");
        set.add("Thanks for your cooperation");
    }

    @Test
    public void testSetAdd(){
        set.add("Hello World.");
        set.add("Yo.");
        for (String str : set){
            System.out.println(str);
        }
    }

    /**
     * 如需进行对象去重
     * 需在Student类中实现equals()和hashcode()方法
     */
    @Test
    public void testSetAddObj(){
        stuSet.add(new Student(1, "张三", 22));
        stuSet.add(new Student(2, "李四", 23));
        stuSet.add(new Student(3, "王五", 24));
        stuSet.add(new Student(3, "王五", 24));
        for (Student stu : stuSet){
            System.out.println(stu);
        }
    }
}
