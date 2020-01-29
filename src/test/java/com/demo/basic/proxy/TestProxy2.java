package com.demo.basic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestProxy2 {
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
