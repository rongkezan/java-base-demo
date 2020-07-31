package com.demo.design.pattern.strategy.behavior;

public class CanSwimBehavior implements SwimBehavior {
    @Override
    public void swim() {
        System.out.println("会游泳");
    }
}
