package com.demo.designPattern.pattern.strategy.behavior;

public class CannotSwimBehavior implements SwimBehavior {
    @Override
    public void swim() {
        System.out.println("不会游泳");
    }
}
