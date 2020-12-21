package com.demo.design.pattern.factoryMode.factory;

import com.demo.design.pattern.factoryMode.entity.HpMouse;
import com.demo.design.pattern.factoryMode.entity.Mouse;

/**
 * @author keith
 */
public class HpMouseFactory extends MouseFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }
}
