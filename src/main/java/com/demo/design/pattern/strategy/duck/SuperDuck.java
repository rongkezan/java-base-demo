package com.demo.design.pattern.strategy.duck;

import com.demo.design.pattern.strategy.behavior.CanSwimBehavior;
import com.demo.design.pattern.strategy.behavior.GoodFlyBehavior;

/**
 * 超级鸭子: 会游泳，飞行技术高超
 */
public class SuperDuck extends Duck {

    public SuperDuck(){
        flyBehavior = new GoodFlyBehavior();
        swimBehavior = new CanSwimBehavior();
    }
    @Override
    public void info() {
        System.out.println("这是超级鸭");
    }
}
