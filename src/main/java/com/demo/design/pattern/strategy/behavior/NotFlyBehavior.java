package com.demo.design.pattern.strategy.behavior;

public class NotFlyBehavior implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("不会飞");
    }
}
