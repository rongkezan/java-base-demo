package com.demo.design.pattern.strategy;

import com.demo.design.pattern.strategy.entity.CashPayment;
import com.demo.design.pattern.strategy.entity.Person;
import com.demo.design.pattern.strategy.entity.WeChatPayment;

/**
 * @author keith
 */
public class Client {
    public static void main(String[] args) {
        Person person = new Person();
        person.setPayment(new CashPayment());
        person.pay();
        person.setPayment(new WeChatPayment());
        person.pay();
        // 也可以通过lambda表达式来自定义实现
        person.setPayment(() -> {
            System.out.println("The pay method is alipay");
        });
        person.pay();
    }
}
