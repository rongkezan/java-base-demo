package com.demo.designPattern.principle.c;

/**
 * 依赖倒转原则: setter传递
 */
interface Operation{
    void open();

    void close();

    void setTv(Tv tv);
}

interface Tv{
    void play();

    void shutdown();
}

class OperationImpl implements Operation {
    private Tv tv;

    @Override
    public void open() {
        tv.play();
    }

    @Override
    public void close() {
        tv.shutdown();
    }

    @Override
    public void setTv(Tv tv) {
        this.tv = tv;
    }
}

class MyTv implements Tv {

    @Override
    public void play() {
        System.out.println("My Tv Start Play.");
    }

    @Override
    public void shutdown() {
        System.out.println("My Tv ShutDown.");
    }
}

public class PrincipleDependency {
    public static void main(String[] args) {
        MyTv myTv = new MyTv();
        Operation operation = new OperationImpl();
        operation.setTv(myTv);
        operation.open();
        operation.close();
    }
}
