package com.demo.designPattern.pattern.bridge;

/**
 * 折叠式手机类，继承 抽象的类
 */
public class FoldedPhone extends Phone {

    public FoldedPhone(Brand brand) {
        super(brand);
    }

    void open() {
        super.open();
        System.out.println("折叠样式手机");
    }

    void close() {
        super.close();
        System.out.println("折叠样式手机");
    }

    void call() {
        super.call();
        System.out.println("折叠样式手机");
    }
}
