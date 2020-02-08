package com.demo.designPattern.pattern.composition;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
abstract class Organization{
    private String name;

    public Organization(String name){
        this.name = name;
    }

    protected void add(Organization organization){
        throw new UnsupportedOperationException();
    }

    protected void remove(Organization organization){
        throw new UnsupportedOperationException();
    }

    protected abstract void print();
}

class University extends Organization{
    List<Organization> organizations = new ArrayList<>();

    public University(String name) {
        super(name);
    }

    @Override
    protected void add(Organization organization) {
        organizations.add(organization);
    }

    @Override
    protected void remove(Organization organization) {
        organizations.remove(organization);
    }

    @Override
    protected void print() {
        System.out.println("---------------" + getName() + "--------------");
        for (Organization organization : organizations) {
            organization.print();
        }
    }
}

class College extends Organization{
    List<Organization> organizations = new ArrayList<>();

    public College(String name) {
        super(name);
    }

    @Override
    protected void add(Organization organization) {
        organizations.add(organization);
    }

    @Override
    protected void remove(Organization organization) {
        organizations.remove(organization);
    }

    @Override
    protected void print() {
        System.out.println("-------" + getName() + "------");
        for (Organization organization : organizations) {
            organization.print();
        }
    }
}

class Department extends Organization{
    public Department(String name) {
        super(name);
    }

    @Override
    protected void print() {
        System.out.println("--" + getName() + "--");
    }
}
public class Client {
    public static void main(String[] args) {
        // 大学
        Organization university = new University("清华大学");
        // 学院
        Organization computerCollege = new College("计算机学院");
        Organization infoCollege = new College("信息工程学院");
        // 将部门加入学院
        computerCollege.add(new Department("人事部"));
        computerCollege.add(new Department("后勤部"));
        infoCollege.add(new Department("学工办"));
        infoCollege.add(new Department("信息中心"));
        // 将学院加入学校
        university.add(computerCollege);
        university.add(infoCollege);
        // 输出
        university.print();
    }
}
