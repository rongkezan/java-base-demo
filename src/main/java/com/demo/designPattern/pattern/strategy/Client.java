package com.demo.designPattern.pattern.strategy;

import com.demo.designPattern.pattern.strategy.behavior.CanSwimBehavior;
import com.demo.designPattern.pattern.strategy.duck.NormalDuck;
import com.demo.designPattern.pattern.strategy.duck.SuperDuck;
import com.demo.designPattern.pattern.strategy.duck.ToyDuck;

public class Client {
    public static void main(String[] args) {
        SuperDuck superDuck = new SuperDuck();
        NormalDuck normalDuck = new NormalDuck();
        ToyDuck toyDuck = new ToyDuck();

        superDuck.info();
        superDuck.swim();
        superDuck.fly();
        System.out.println("------------------");
        normalDuck.info();
        normalDuck.swim();
        normalDuck.fly();
        System.out.println("------------------");
        toyDuck.info();
        toyDuck.swim();
        toyDuck.fly();
        System.out.println("--------改变玩具鸭行为 会游泳----------");
        toyDuck.setSwimBehavior(new CanSwimBehavior());
        toyDuck.info();
        toyDuck.swim();
    }
}
