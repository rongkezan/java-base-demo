package com.demo.basic.annotation;

/**
 * @author keith
 */
public class DatabaseConnection implements Connection {
    @Override
    public boolean build() {
        System.out.println("Connect to database");
        return true;
    }
}
