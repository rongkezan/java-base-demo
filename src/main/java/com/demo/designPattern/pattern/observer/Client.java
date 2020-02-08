package com.demo.designPattern.pattern.observer;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void actionOnWakeup(WakeupEvent event);
}

class Dad implements Observer{
    public void feed(){
        System.out.println("Dad feed...");
    }

    @Override
    public void actionOnWakeup(WakeupEvent event) {
        feed();
    }
}

class Mon implements Observer{
    public void hug(){
        System.out.println("Mon feed...");
    }
    @Override
    public void actionOnWakeup(WakeupEvent event) {
        hug();
    }
}

class Dog implements Observer{
    public void wang(){
        System.out.println("Dog wang...");
    }
    @Override
    public void actionOnWakeup(WakeupEvent event) {
        wang();
    }
}

class Child{
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mon());
        observers.add(new Dog());
    }

    public void wakeup(){
        cry = true;
        WakeupEvent event = new WakeupEvent(System.currentTimeMillis(), "bed");
        for (Observer o : observers){
            o.actionOnWakeup(event);
        }
    }
}

abstract class Event<T>{
    abstract T getSource();
}

class WakeupEvent extends Event<Child>{
    long timestamp;
    String location;
    Child source;

    public WakeupEvent(long timestamp, String location){
        this.timestamp = timestamp;
        this.location = location;
    }

    @Override
    public Child getSource() {
        return source;
    }
}

public class Client{
    public static void main(String[] args) {
        new Child().wakeup();
    }
}
