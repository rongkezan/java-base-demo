package com.demo.designPattern.pattern.decorator.drink;

import com.demo.designPattern.pattern.decorator.Decorator;
import com.demo.designPattern.pattern.decorator.drink.Drink;

// 具体的Decorator，这里是调味品
public class Chocolate extends Decorator {

    public Chocolate(Drink drink) {
        super(drink);
        setDescription("巧克力");
        setPrice(3.0f);
    }
}
