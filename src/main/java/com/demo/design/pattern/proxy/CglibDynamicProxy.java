package com.demo.design.pattern.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 动态代理cglib可以代理没有实现接口的类
 */
public class CglibDynamicProxy {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("before");
            Object o1 = methodProxy.invokeSuper(o, objects);
            System.out.println("after");
            return o1;
        });
        Tank tank = (Tank) enhancer.create();
        tank.print();
    }

    static class Tank{
        public void print(){
            System.out.println("I'm Tank");
        }
    }
}
