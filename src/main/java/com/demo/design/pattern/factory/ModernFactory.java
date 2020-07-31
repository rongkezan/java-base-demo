package com.demo.design.pattern.factory;

import com.demo.design.pattern.factory.food.Bread;
import com.demo.design.pattern.factory.food.Food;
import com.demo.design.pattern.factory.vehicle.Car;
import com.demo.design.pattern.factory.vehicle.Vehicle;

/**
 * 现代人 工厂
 */
public class ModernFactory extends AbstractFactory {

    @Override
    public Food createFood() {
        return new Bread();
    }

    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}
