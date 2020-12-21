package com.demo.design.pattern.abstractFactoryMode;

import com.demo.design.pattern.abstractFactoryMode.factory.HpFactory;
import com.demo.design.pattern.abstractFactoryMode.factory.PcFactory;

/**
 * @author keith
 */
public class Client {
    public static void main(String[] args) {
        PcFactory pcFactory = new HpFactory();
        pcFactory.createKeyboard().print();
        pcFactory.createMouse().print();
    }
}
