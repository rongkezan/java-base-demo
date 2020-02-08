package com.demo.designPattern.pattern.strategy.behavior;

public class GoodFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("飞行技术高超");
    }
}
