package com.demo.design.pattern.factory;

import com.demo.design.pattern.factory.food.Food;
import com.demo.design.pattern.factory.vehicle.Vehicle;

public abstract class AbstractFactory {

    public abstract Food createFood();

    public abstract Vehicle createVehicle();
}
