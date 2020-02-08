package com.demo.designPattern.pattern.strategy.behavior;

public class BadFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("飞行技术不高超");
    }
}
