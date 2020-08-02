package com.demo.design.pattern.bridge;

/**
 * 使用聚合的方式将两个类进行关联，解决类爆炸的问题
 * 举例: 小米手机 + 滑盖 = 小米滑盖手机
 */
interface Brand {
    void open();

    void close();

    void call();
}

class Vivo implements Brand {
    @Override
    public void open() {
        System.out.println("Vivo open");
    }

    @Override
    public void close() {
        System.out.println("Vivo close");
    }

    @Override
    public void call() {
        System.out.println("Vivo call");
    }
}

class XiaoMi implements Brand {
    @Override
    public void open() {
        System.out.println("Xiaomi open");
    }

    @Override
    public void close() {
        System.out.println("Xiaomi close");
    }

    @Override
    public void call() {
        System.out.println("Xiaomi call");
    }
}


abstract class Phone {
    private Brand brand;

    public Phone(Brand brand){
        this.brand = brand;
    }

    void open(){
        this.brand.open();
    }

    void close(){
        this.brand.close();
    }

    void call(){
        this.brand.call();
    }
}

class FoldedPhone extends Phone {
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

class SlidePhone extends Phone{
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

public class Client {
    public static void main(String[] args) {
        new FoldedPhone(new Vivo()).open();

        new SlidePhone(new Vivo()).close();

        new FoldedPhone(new XiaoMi()).call();

        new SlidePhone(new XiaoMi()).open();
    }
}
