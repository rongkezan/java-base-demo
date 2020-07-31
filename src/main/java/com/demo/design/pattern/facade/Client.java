package com.demo.design.pattern.facade;

class Cpu {
    public void start() {
        System.out.println("Cpu start");
    }

    public void shutdown() {
        System.out.println("Cpu shutdown");
    }
}

class Memory {
    public void start() {
        System.out.println("Memory start");
    }

    public void shutdown() {
        System.out.println("Memory shutdown");
    }
}

class Disk{
    public void start() {
        System.out.println("Disk start");
    }

    public void shutdown() {
        System.out.println("Disk shutdown");
    }
}

class Computer{
    private Cpu cpu;
    private Memory memory;
    private Disk disk;

    public Computer(){
        cpu = new Cpu();
        memory = new Memory();
        disk = new Disk();
    }

    public void start(){
        cpu.start();
        memory.start();
        disk.start();
    }

    public void shutdown(){
        cpu.shutdown();
        memory.shutdown();
        disk.shutdown();
    }
}

public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.start();
        computer.shutdown();
    }
}
