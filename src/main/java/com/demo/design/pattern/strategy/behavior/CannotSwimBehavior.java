package com.demo.design.pattern.strategy.behavior;

public class CannotSwimBehavior implements SwimBehavior {
    @Override
    public void swim() {
        System.out.println("不会游泳");
    }
}
