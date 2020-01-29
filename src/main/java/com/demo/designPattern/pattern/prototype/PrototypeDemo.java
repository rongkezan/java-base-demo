package com.demo.designPattern.pattern.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 原型设计模式案例
 * 现有一只羊Tom，年龄为1，白色
 * 请编写程序创建5只相同的羊
 * 思路: Object类提供clone()方法，可以将对象复制一份，需要实现Cloneable接口
 */
public class PrototypeDemo {
    @Data
    @AllArgsConstructor
    static class Sheep implements Cloneable{
        private String name;
        private Integer age;
        private String color;

        @Override
        protected Sheep clone(){
            Sheep sheep = null;
            try {
                sheep = (Sheep) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return sheep;
        }
    }

    public static void main(String[] args) {
        Sheep sheep = new Sheep("Tom", 1, "白色");
        Sheep sheep1 = sheep.clone();
        Sheep sheep2 = sheep.clone();
        Sheep sheep3 = sheep.clone();
        Sheep sheep4 = sheep.clone();
        Sheep sheep5 = sheep.clone();
    }
}
