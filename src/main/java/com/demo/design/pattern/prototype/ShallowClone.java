package com.demo.design.pattern.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Object类提供clone()方法，可以将对象复制一份，需要实现Cloneable接口
 * 浅克隆 克隆的是源对象的对象的地址 当源对象的对象中的值发生改变 相应克隆的类也将发生改变
 */
public class ShallowClone {

    @Data
    @AllArgsConstructor
    static class Location {
        private Integer x;
        private Integer y;
    }

    @Data
    @AllArgsConstructor
    static class Sheep implements Cloneable {
        private String name;
        private Integer age;
        private String color;
        private Location loc;

        @Override
        protected Sheep clone() throws CloneNotSupportedException {
            return (Sheep) super.clone();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep sheep1 = new Sheep("Tom", 1, "白色", new Location(100, 100));
        Sheep sheep2 = sheep1.clone();
        System.out.println(sheep1.getLoc() == sheep2.getLoc());
        sheep1.getLoc().setX(0);
        System.out.println(sheep1);
        System.out.println(sheep2);
    }
}
