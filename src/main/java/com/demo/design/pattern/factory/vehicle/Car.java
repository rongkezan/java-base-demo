package com.demo.design.pattern.factory.vehicle;

public class Car extends Vehicle {

    public Car(){
        System.out.println("Car Created");
    }

    @Override
    public void print() {
        System.out.println("I'm Car");
    }
}
