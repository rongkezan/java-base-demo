package com.demo.design.principle.a;

/**
 * 依赖倒转原则: 构造方法传递
 */
interface Operation{
    void open();

    void close();
}

interface Tv{
    void play();

    void shutdown();
}

class OperationImpl implements Operation{
    private Tv tv;

    public OperationImpl(Tv tv){
        this.tv = tv;
    }

    @Override
    public void open() {
        tv.play();
    }

    @Override
    public void close() {
        tv.shutdown();
    }
}

class MyTv implements Tv{

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
        Operation operation = new OperationImpl(myTv);
        operation.open();
        operation.close();
    }
}
