package com.demo.basic;

/**
 * 普通内部类的实例化演示
 */
public class NormalInnerClass {
    public static void main(String[] args) {
        Outer1 outer1 = new Outer1();
        Outer1.TestDemo testDemo = outer1.new TestDemo();
        System.out.println(testDemo);
    }
}

class Outer1{
    class TestDemo{
        public TestDemo(){
            System.out.println("--- 我被实例化了 ---");
        }
    }
}
