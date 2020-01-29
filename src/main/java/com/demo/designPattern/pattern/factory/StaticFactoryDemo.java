package com.demo.designPattern.pattern.factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StaticFactoryDemo {
    static abstract class Pizza{
        String name;

        public abstract void prepare();

        public void bake(){
            System.out.println(name + " is baking");
        }

        public void cut(){
            System.out.println(name + " is cutting");
        }

        public void box(){
            System.out.println(name + " is boxing");
        }

        public void setName(String name){
            this.name = name;
        }
    }

    static class GreekPizza extends Pizza {

        public GreekPizza(){
            super.setName("希腊披萨");
        }

        @Override
        public void prepare() {
            System.out.println("给希腊披萨准备原材料");
        }
    }

    static class CheesePizza extends Pizza {

        public CheesePizza(){
            super.setName("奶酪披萨");
        }

        @Override
        public void prepare() {
            System.out.println("给奶酪披萨准备原材料");
        }
    }

    static class StaticFactory{
        public static Pizza createPizza(Integer type){
            Pizza pizza = null;
            if (type == 1){
                pizza = new GreekPizza();
            } else if(type == 2) {
                pizza = new CheesePizza();
            }
            return pizza;
        }
    }

    static class OrderPizza{
        private Pizza pizza;
        private Integer type;
        private StaticFactory staticFactory;

        public OrderPizza(){
            type = getType();
            pizza = this.staticFactory.createPizza(type);
            if (pizza == null){
                System.out.println("没有相应的Pizza");
            }
            System.out.println("成功订购到了" + pizza.name);
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }

        public Integer getType(){
            String type;
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("input pizza which you want: ");
                type = bufferedReader.readLine();
                return Integer.parseInt(type);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static void main(String[] args) {
        new OrderPizza();
    }
}
