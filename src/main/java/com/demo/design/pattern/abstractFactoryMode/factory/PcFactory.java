package com.demo.design.pattern.abstractFactoryMode.factory;

import com.demo.design.pattern.abstractFactoryMode.entity.Keyboard;
import com.demo.design.pattern.abstractFactoryMode.entity.Mouse;

public abstract class PcFactory {
    public abstract Mouse createMouse();

    public abstract Keyboard createKeyboard();
}
