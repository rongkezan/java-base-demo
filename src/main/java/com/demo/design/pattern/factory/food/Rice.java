package com.demo.design.pattern.factory.food;

public class Rice extends Food {

    public Rice(){
        System.out.println("Rice Created");
    }

    @Override
    public void print() {
        System.out.println("I'm Rice");
    }
}
