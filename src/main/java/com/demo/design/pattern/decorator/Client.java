package com.demo.design.pattern.decorator;

import lombok.Data;

/**
 * 星巴克点单: 一份咖啡 + 多份配料
 * 装饰着模式下的订单: 1杯Long Black + 2份巧克力 + 1份牛奶
 */
@Data
abstract class Goods {
    private String description;

    private float price = 0.0f;

    public abstract float cost();   // 价格
}

class Coffee extends Goods {
    @Override
    public float cost() {
        return super.getPrice();
    }
}

class Ingredient extends Goods {
    private Goods goods;

    public Ingredient(Goods goods) {
        this.goods = goods;
    }

    @Override
    public float cost() {
        return getPrice() + goods.cost();
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(goods.getDescription() + ", " + description);
    }
}

class Decaf extends Coffee {
    public Decaf(){
        setDescription("脱因咖啡");
        setPrice(10.0f);
    }
}

class Milk extends Ingredient {
    public Milk(Goods goods) {
        super(goods);
        setDescription("牛奶");
        setPrice(2.0f);
    }
}

class Chocolate extends Ingredient {
    public Chocolate(Goods goods) {
        super(goods);
        setDescription("巧克力");
        setPrice(3.0f);
    }
}

public class Client {
    public static void main(String[] args) {
        // 点一份Long Black
        Goods order = new Decaf();
        // 加一份牛奶
        order = new Milk(order);
        // 加两份巧克力
        order = new Chocolate(order);
        order = new Chocolate(order);
        System.out.println("订单: " + order.getDescription());
        System.out.println("总费用: " + order.cost());
    }
}
