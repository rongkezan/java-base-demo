package com.demo.design.pattern.factory.vehicle;

public class Wagon extends Vehicle {

    public Wagon(){
        System.out.println("Wagon Created");
    }

    @Override
    public void print() {
        System.out.println("I'm Wagon");
    }
}
