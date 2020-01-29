package com.demo.designPattern.principle.b;

/**
 * 依赖倒转原则: 接口传递
 */
interface Operation{
    void open(Tv tv);

    void close(Tv tv);
}

interface Tv{
    void play();

    void shutdown();
}

class OperationImpl implements Operation {

    @Override
    public void open(Tv tv) {
        tv.play();
    }

    @Override
    public void close(Tv tv) {
        tv.shutdown();
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
        operation.open(myTv);
        operation.close(myTv);
    }
}
