package com.demo.design.pattern.strategy.duck;

import com.demo.design.pattern.strategy.behavior.FlyBehavior;
import com.demo.design.pattern.strategy.behavior.SwimBehavior;

public abstract class Duck {
    // 属性，策略接口
    protected FlyBehavior flyBehavior;
    protected SwimBehavior swimBehavior;

    public abstract void info();

    public void swim(){
        if (swimBehavior != null){
            swimBehavior.swim();
        }
    }

    public void fly(){
        if(flyBehavior != null){
            flyBehavior.fly();
        }
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setSwimBehavior(SwimBehavior swimBehavior) {
        this.swimBehavior = swimBehavior;
    }
}
