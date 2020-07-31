package com.demo.design.pattern.strategy.duck;

import com.demo.design.pattern.strategy.behavior.CannotSwimBehavior;
import com.demo.design.pattern.strategy.behavior.NotFlyBehavior;

/**
 * 玩具鸭子: 不会游泳，不会飞
 */
public class ToyDuck extends Duck{

    public ToyDuck(){
        flyBehavior = new NotFlyBehavior();
        swimBehavior = new CannotSwimBehavior();
    }

    @Override
    public void info() {
        System.out.println("这是玩具鸭");
    }


}
