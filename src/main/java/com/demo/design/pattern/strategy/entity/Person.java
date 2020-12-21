package com.demo.design.pattern.strategy.entity;

/**
 * @author keith
 */
public class Person {
    Payment payment;

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void pay(){
        payment.pay();
    }
}
