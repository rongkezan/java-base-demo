package com.demo.design.pattern.factory;

import com.demo.design.pattern.factory.food.Food;
import com.demo.design.pattern.factory.vehicle.Vehicle;

/**
 * 现代人开汽车 吃面包
 * 古代人骑马车 吃米饭
 * 两种不同的工厂对应两种不同的风格，可随意进行切换
 */
public class Main {
    public static void main(String[] args) {
        // 切换风格时只需切换对应的工厂
        AbstractFactory factory = new AncientFactory();
        Food food = factory.createFood();
        Vehicle vehicle = factory.createVehicle();
        food.print();
        vehicle.print();
    }
}
