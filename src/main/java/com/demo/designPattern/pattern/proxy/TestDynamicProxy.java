package com.demo.designPattern.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestDynamicProxy {
    interface Human{
        String getBelief();

        void eat(String food);
    }

    static class SuperMan implements Human {

        @Override
        public String getBelief() {
            return "I believe I can fly";
        }

        @Override
        public void eat(String food) {
            System.out.println("我喜欢吃" + food);
        }
    }

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        // 定义handler
        InvocationHandler handler = (proxy, method, args1) -> method.invoke(superMan, args1);
        // 获取代理类对象
        Human proxyInstance = (Human) Proxy.newProxyInstance(superMan.getClass().getClassLoader(), superMan.getClass().getInterfaces(), handler);
        // 测试
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("苹果");
    }
}
