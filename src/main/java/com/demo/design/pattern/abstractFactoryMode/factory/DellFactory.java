package com.demo.design.pattern.abstractFactoryMode.factory;

import com.demo.design.pattern.abstractFactoryMode.entity.DellKeyboard;
import com.demo.design.pattern.abstractFactoryMode.entity.DellMouse;
import com.demo.design.pattern.abstractFactoryMode.entity.Keyboard;
import com.demo.design.pattern.abstractFactoryMode.entity.Mouse;

/**
 * @author keith
 */
public class DellFactory extends PcFactory {
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new DellKeyboard();
    }
}
