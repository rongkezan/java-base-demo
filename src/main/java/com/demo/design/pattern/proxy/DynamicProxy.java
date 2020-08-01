package com.demo.design.pattern.proxy;

import java.lang.reflect.Proxy;

/**
 * Jdk动态代理只能代理有接口的类
 */
public class DynamicProxy {

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        // 获取代理类对象
        Human proxyInstance = (Human) Proxy.newProxyInstance(superMan.getClass().getClassLoader(), superMan.getClass().getInterfaces(),
                (proxy, method, args1) -> method.invoke(superMan, args1));
        // 测试
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("苹果");
    }

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
}
