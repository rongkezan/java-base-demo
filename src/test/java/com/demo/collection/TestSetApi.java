package com.demo.collection;

import com.demo.collection.entity.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class TestSetApi {

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
        stuSet.add(new Student(20160001L, "孔明", 20, 1, "土木工程", "武汉大学"));
        stuSet.add(new Student(20160002L, "伯约", 21, 2, "信息安全", "武汉大学"));
        stuSet.add(new Student(20160003L, "玄德", 22, 3, "经济管理", "武汉大学"));
        stuSet.add(new Student(20160004L, "云长", 21, 2, "信息安全", "武汉大学"));
        stuSet.add(new Student(20161001L, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
        stuSet.add(new Student(20161002L, "元直", 23, 4, "土木工程", "华中科技大学"));
        stuSet.add(new Student(20161003L, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
        stuSet.add(new Student(20162001L, "仲谋", 22, 3, "土木工程", "浙江大学"));
        stuSet.add(new Student(20162002L, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
        stuSet.add(new Student(20163001L, "丁奉", 24, 5, "土木工程", "南京大学"));
        for (Student stu : stuSet){
            System.out.println(stu);
        }
    }
}
