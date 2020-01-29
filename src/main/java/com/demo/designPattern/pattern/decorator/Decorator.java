package com.demo.designPattern.pattern.decorator;

import com.demo.designPattern.pattern.decorator.drink.Drink;

public class Decorator extends Drink {
    private Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public float cost() {
        return getPrice() + drink.cost();
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(drink.getDescription() + ", " + description);
    }
}
