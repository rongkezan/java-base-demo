package com.demo.design.pattern.strategy.duck;

import com.demo.design.pattern.strategy.behavior.BadFlyBehavior;
import com.demo.design.pattern.strategy.behavior.CanSwimBehavior;

/**
 * 普通鸭子: 会游泳，飞行技术一般
 */
public class NormalDuck extends Duck {
    public NormalDuck(){
        flyBehavior = new BadFlyBehavior();
        swimBehavior = new CanSwimBehavior();
    }

    @Override
    public void info() {
        System.out.println("这是普通鸭子");
    }
}
