package com.demo.design.pattern.factoryMode.factory;

import com.demo.design.pattern.factoryMode.entity.DellMouse;
import com.demo.design.pattern.factoryMode.entity.Mouse;

/**
 * @author keith
 */
public class DellMouseFactory extends MouseFactory{
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }
}
