package com.demo.design.pattern.factory.food;

public class Bread extends Food {

    public Bread(){
        System.out.println("Bread Created");
    }

    @Override
    public void print() {
        System.out.println("I'm Bread.");
    }
}
