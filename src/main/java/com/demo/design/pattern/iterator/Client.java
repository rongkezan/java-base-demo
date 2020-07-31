package com.demo.design.pattern.iterator;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
@AllArgsConstructor
class Department{
    private String name;
    private String desc;
}

class ComputerCollegeIterator implements Iterator {
    // 计算机学院是以数组的方式存放系的
    private Department[] departments;
    private int pos;

    public ComputerCollegeIterator(Department[] departments){
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if (pos >= departments.length || departments[pos] == null){
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        Department department = departments[pos];
        pos += 1;
        return department;
    }
}

class InfoCollegeIterator implements Iterator{
    // 信息工程学院是以List的方式存放系的
    private List<Department> departmentList;
    private int index;

    public InfoCollegeIterator(List<Department> departmentList){
        this.departmentList = departmentList;
    }
    @Override
    public boolean hasNext() {
        if (index >= departmentList.size() - 1){
            return false;
        }
        index += 1;
        return true;
    }

    @Override
    public Object next() {
        return departmentList.get(index);
    }
}

interface College{
    String getName();

    void addDepartment(String name, String desc);

    Iterator newIterator();
}

class ComputerCollege implements College{

    Department[] departments;
    int count;  // 保存当前数组的对象个数

    public ComputerCollege(){
        departments = new Department[5];
        addDepartment("Java专业", "Java专业");
        addDepartment("Php专业", "Php专业");
        addDepartment("大数据专业", "大数据专业");
    }

    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name, desc);
        departments[count] = department;
        count += 1;
    }

    @Override
    public Iterator newIterator() {
        return new ComputerCollegeIterator(departments);
    }
}

class InfoCollege implements College{
    private List<Department> departmentList;

    public InfoCollege(){
        departmentList = new ArrayList<>();
        addDepartment("信息安全", "信息安全");
        addDepartment("网络安全", "网络安全");
        addDepartment("服务器安全", "服务器安全");
    }

    @Override
    public String getName() {
        return "信息工程学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name, desc);
        departmentList.add(department);
    }

    @Override
    public Iterator newIterator() {
        return new InfoCollegeIterator(departmentList);
    }
}

class Output{
    List<College> collegeList;

    public Output(List<College> collegeList){
        this.collegeList = collegeList;
    }

    public void printCollege(){
        Iterator<College> iterator = collegeList.iterator();
        while (iterator.hasNext()){
            College college = iterator.next();
            System.out.println("--- " + college.getName() + " ---");
            printDepartment(college.newIterator());
        }
    }

    public void printDepartment(Iterator iterator){
        while (iterator.hasNext()){
            Department department = (Department) iterator.next();
            System.out.println(department.getName());
        }
    }
}

public class Client {
    public static void main(String[] args) {
        List<College> collegeList = new ArrayList<>();

        ComputerCollege computerCollege = new ComputerCollege();
        InfoCollege infoCollege = new InfoCollege();

        collegeList.add(computerCollege);
        collegeList.add(infoCollege);

        Output output = new Output(collegeList);
        output.printCollege();
    }
}
