package com.demo.basic;

/**
 * 静态变量作用在类层面，所有实例都会共享
 * @author keith
 */
public class StaticVariableDemo {
    static int num;

    {
        num++;
    }

    void plus(){
        num++;
    }

    public static void main(String[] args) {
        StaticVariableDemo d1 = new StaticVariableDemo();
        StaticVariableDemo d2 = new StaticVariableDemo();
        d1.plus();
        d2.plus();
        System.out.println(num);
    }
}
