package com.demo.designPattern.pattern.decorator.drink;

public class Coffee extends Drink {
    @Override
    public float cost() {
        return super.getPrice();
    }
}
