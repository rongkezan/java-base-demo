package com.demo.designPattern.pattern.decorator.drink;

public abstract class Drink {
    private String description;

    private float price = 0.0f;

    public abstract float cost();   // 价格

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
