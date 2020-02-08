package com.demo.designPattern.pattern.strategy.behavior;

public class NotFlyBehavior implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("不会飞");
    }
}
