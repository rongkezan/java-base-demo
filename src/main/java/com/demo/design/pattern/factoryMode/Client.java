package com.demo.design.pattern.factoryMode;

import com.demo.design.pattern.factoryMode.factory.DellMouseFactory;
import com.demo.design.pattern.factoryMode.factory.MouseFactory;

/**
 * 可以通过不同的工厂生产不同的鼠标
 */
public class Client {
    public static void main(String[] args) {
        MouseFactory factory = new DellMouseFactory();
        factory.createMouse().print();
    }
}
