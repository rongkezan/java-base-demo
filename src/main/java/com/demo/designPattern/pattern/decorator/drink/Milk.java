package com.demo.designPattern.pattern.decorator.drink;

import com.demo.designPattern.pattern.decorator.Decorator;
import com.demo.designPattern.pattern.decorator.drink.Drink;

public class Milk extends Decorator {

    public Milk(Drink drink) {
        super(drink);
        setDescription("牛奶");
        setPrice(2.0f);
    }
}
