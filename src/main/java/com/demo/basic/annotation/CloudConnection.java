package com.demo.basic.annotation;

/**
 * @author keith
 */
public class CloudConnection implements Connection {
    @Override
    public boolean build() {
        System.out.println("Connect to cloud");
        return true;
    }
}
