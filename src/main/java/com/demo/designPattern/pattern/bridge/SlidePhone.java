package com.demo.designPattern.pattern.bridge;

public class SlidePhone extends Phone{

    public SlidePhone(Brand brand) {
        super(brand);
    }

    @Override
    void open() {
        super.open();
        System.out.println("滑盖式手机");
    }

    @Override
    void close() {
        super.close();
        System.out.println("滑盖式手机");
    }

    @Override
    void call() {
        super.call();
        System.out.println("滑盖式手机");
    }
}
