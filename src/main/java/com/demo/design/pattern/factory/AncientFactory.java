package com.demo.design.pattern.factory;

import com.demo.design.pattern.factory.food.Food;
import com.demo.design.pattern.factory.food.Rice;
import com.demo.design.pattern.factory.vehicle.Vehicle;
import com.demo.design.pattern.factory.vehicle.Wagon;

/**
 * 古代人 工厂
 */
public class AncientFactory extends AbstractFactory {

    @Override
    public Food createFood() {
        return new Rice();
    }

    @Override
    public Vehicle createVehicle() {
        return new Wagon();
    }
}
