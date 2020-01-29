package com.demo.designPattern.pattern.decorator;

import com.demo.designPattern.pattern.decorator.drink.*;

/**
 * 装饰着模式下的订单: 1杯Long Black + 2份巧克力 + 1份牛奶
 */
public class Client {
    public static void main(String[] args) {
        // 点一份Long Black
        Drink order = new LongBlack();
        // 加一份牛奶
        order = new Milk(order);
        // 加两份巧克力
        order = new Chocolate(order);
        order = new Chocolate(order);
        System.out.println("订单: " + order.getDescription());
        System.out.println("总费用: " + order.cost());
    }
}
