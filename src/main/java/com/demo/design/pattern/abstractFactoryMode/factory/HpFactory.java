package com.demo.design.pattern.abstractFactoryMode.factory;

import com.demo.design.pattern.abstractFactoryMode.entity.HpKeyboard;
import com.demo.design.pattern.abstractFactoryMode.entity.HpMouse;
import com.demo.design.pattern.abstractFactoryMode.entity.Keyboard;
import com.demo.design.pattern.abstractFactoryMode.entity.Mouse;

/**
 * @author keith
 */
public class HpFactory extends PcFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new HpKeyboard();
    }
}
